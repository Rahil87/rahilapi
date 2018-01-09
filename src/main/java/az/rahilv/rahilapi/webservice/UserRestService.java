package az.rahilv.rahilapi.webservice;


import az.rahilv.rahilapi.response.RespUser;

public interface UserRestService {

    RespUser checkUser(String username, String password);

}
