import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
        testProjections();
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

    private void testProjections() {
//        usersWithDescendingId();
//        usersId();
        getObjectsUsingExmapleObject();
    }

    private void usersWithDescendingId() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class)
                .addOrder(Order.desc("id"));

        List<User> users = (List<User>) criteria.list();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void usersId() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class)
                .setProjection(Projections.property("id"));

        List<Integer> ids = (List<Integer>) criteria.list();
        for (Integer id : ids) {
            System.out.println(id);
        }
    }

    private void getObjectsUsingExmapleObject() {
        Session session = sessionFactory.openSession();

        User exampleUser = new User();
        exampleUser.setId(3);
        exampleUser.setName("User3");
        Example example = Example.create(exampleUser);

        Criteria criteria = session.createCriteria(User.class)
                .add(example);

        List<User> users = criteria.list();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
