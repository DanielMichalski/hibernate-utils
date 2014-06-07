package dao;

import entity.User;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IUserDao {

    public List<User> getAllUsers();

    public void saveUser(User user);
}
