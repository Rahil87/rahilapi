package az.rahilv.rahilapi.webservice;

import az.rahilv.rahilapi.model.User;
import az.rahilv.rahilapi.response.RespStatus;
import az.rahilv.rahilapi.response.RespUser;
import az.rahilv.rahilapi.service.UserService;
import az.rahilv.rahilapi.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


public class UserRestServiceImpl implements UserRestService {

    @Autowired
    private UserService userService;

    @Override
    @GET
    @Path("/checkUser")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespUser checkUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        RespUser response = new RespUser();
        User user = userService.checkUser(username,password);

        try {
            if (user != null) {
                response.setName(user.getName());
                response.setSurname(user.getSurname());
                response.setUsername(user.getUsername());
                RespStatus respStatus = new RespStatus();
                respStatus.setStatusCode(1);
                respStatus.setStatusMessage("success");
                response.setRespStatus(respStatus);
            } else {
                RespStatus respStatus = new RespStatus();
                respStatus.setStatusCode(ExceptionConstants.USER_NOT_EXISTS);
                respStatus.setStatusMessage("User not exists");
                response.setRespStatus(respStatus);
            }
        } catch (Exception ex) {
            RespStatus respStatus = new RespStatus();
            respStatus.setStatusCode(ExceptionConstants.INTERNAL_EXCEPTION);
            respStatus.setStatusMessage("Internal Exception");
            response.setRespStatus(respStatus);
            ex.printStackTrace();
        }

        return response;
    }

    @Override
    @GET
    @Path("/getAllUsersList")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<RespUser> getAllUsersList() {
        List<RespUser>respUserList= new ArrayList<>() ;
            RespUser respUser = new RespUser();
            try {
                List<User>userList=userService.getAllUsersList();
                for (User user:userList) {
                    respUser.setName(user.getName());
                    respUser.setSurname(user.getSurname());
                    respUser.setUsername(user.getUsername());
                    respUserList.add(respUser);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return respUserList;
            }

    @Override
    @POST
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void addUsers(RespUser respUser) {
        RespUser respUser1= new RespUser();
        try {
            User user= new User();
           user.setName(respUser1.getName());
            user.setSurname(respUser1.getSurname());
            user.setUsername(respUser1.getUsername());
            user.setPassword(respUser1.getPassword());
            userService.addUsers(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        }


    }




