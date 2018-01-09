package az.rahilv.rahilapi.webservice;

import az.rahilv.rahilapi.model.User;
import az.rahilv.rahilapi.response.RespStatus;
import az.rahilv.rahilapi.response.RespUser;
import az.rahilv.rahilapi.service.UserService;
import az.rahilv.rahilapi.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


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
}
