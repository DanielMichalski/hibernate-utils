package dao;

import entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Daniel
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User get(int id) {
        Session session = sessionFactory.openSession();
        Query namedQuery = session.getNamedQuery("User.byId");
        Query query = namedQuery.setInteger(0, 2);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();

        user.setName("test");

        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        return query.list();
    }
}
