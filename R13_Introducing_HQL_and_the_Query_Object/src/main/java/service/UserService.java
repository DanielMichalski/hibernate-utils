package service;

import dao.IUserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Daniel
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
