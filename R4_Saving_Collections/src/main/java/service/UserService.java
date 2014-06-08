package service;

import dao.IUserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: Daniel
 */
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
