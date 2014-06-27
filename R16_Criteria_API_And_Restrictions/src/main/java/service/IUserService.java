package service;

import entity.User;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IUserService {
    public User get(int id);

    public List<User> getAllUsers();

    public void saveUser(User user);
}
