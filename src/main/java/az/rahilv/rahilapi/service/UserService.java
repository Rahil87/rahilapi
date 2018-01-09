package az.rahilv.rahilapi.service;

import az.rahilv.rahilapi.model.User;

public interface UserService {

    User checkUser(String username,String password);

}
