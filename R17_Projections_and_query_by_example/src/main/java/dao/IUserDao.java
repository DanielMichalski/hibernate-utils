package dao;

import entity.User;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IUserDao {
    public User get(int id);

    public void saveUser(User user);

    List<User> getAllUsers();
}
