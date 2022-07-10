package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void editUser(long id, User user);

    public void deleteUser(long id);

    public User getUserById(long id);
}
