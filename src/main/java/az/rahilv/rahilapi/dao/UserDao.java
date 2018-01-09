package az.rahilv.rahilapi.dao;

import az.rahilv.rahilapi.model.User;

import java.util.List;

public interface UserDao {

    User checkUser(String username, String password);
    public List<User>getAllUsersList();
    public void addUsers(User user);
}
