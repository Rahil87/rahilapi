package az.rahilv.rahilapi.dao;

import az.rahilv.rahilapi.model.User;

public interface UserDao {

    User checkUser(String username, String password);

}
