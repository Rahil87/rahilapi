package az.rahilv.rahilapi.service;

import az.rahilv.rahilapi.model.User;

import java.util.List;

public interface UserService {

    User checkUser(String username,String password);
    public List<User> getAllUsersList();
    public  void addUsers(User user);
}
