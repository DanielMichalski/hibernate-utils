package service;

import entity.User;

/**
 * Author: Daniel
 */
public interface IUserService {
    public User get(int id);

    public void saveUser(User user);
}
