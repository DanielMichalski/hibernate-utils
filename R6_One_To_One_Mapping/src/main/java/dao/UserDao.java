package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author: Daniel
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User get(int id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, 1);
        session.close();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
