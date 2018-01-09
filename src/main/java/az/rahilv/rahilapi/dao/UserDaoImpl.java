package az.rahilv.rahilapi.dao;

import az.rahilv.rahilapi.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

    @Override
    public User checkUser(String username, String password) {
        return (User) getSession().getNamedQuery("User.checkUser").setParameter("username",username).setParameter("password",password).uniqueResult();
    }

    @Override
    public List<User> getAllUsersList() {
        return getSession().getNamedQuery("User.findAll").list();
    }

    @Override
    public void addUsers(User user) {
        getSession().save(user);

    }
}
