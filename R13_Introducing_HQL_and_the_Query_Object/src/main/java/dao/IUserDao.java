package dao;

import entity.User;

/**
 * Author: Daniel
 */
public interface IUserDao {
    public User get(int id);

    public void saveUser(User user);
}
