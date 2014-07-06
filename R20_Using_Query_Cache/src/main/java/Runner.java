import entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserService;

import java.util.List;

/**
 * Author: Daniel
 */
public class Runner {

    private IUserService userService;

    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        new Runner();
    }

    public Runner() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        userService = context.getBean(UserService.class);
        sessionFactory = context.getBean(SessionFactory.class);

        saveUsers();
        testCacheing();
    }

    private void saveUsers() {
        User user1 = new User();
        user1.setName("User1");

        User user2 = new User();
        user2.setName("User2");

        User user3 = new User();
        user3.setName("User3");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
    }

    private void testCacheing() {
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query = session1.createQuery("from User where id = 1");
        query.setCacheable(true);
        List users1 = query.list();
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from User where id = 1");
        query2.setCacheable(true);
        List users2 = query2.list();
        session2.getTransaction().commit();
        session2.close();

        System.out.println(users1);
        System.out.println(users2);
    }
}
