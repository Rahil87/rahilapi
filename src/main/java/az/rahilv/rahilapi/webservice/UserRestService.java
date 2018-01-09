package az.rahilv.rahilapi.webservice;


import az.rahilv.rahilapi.model.User;
import az.rahilv.rahilapi.response.RespUser;

import java.util.List;

public interface UserRestService {

    RespUser checkUser(String username, String password);
    public List<RespUser> getAllUsersList();
    public  void addUsers(RespUser respUser);
}
