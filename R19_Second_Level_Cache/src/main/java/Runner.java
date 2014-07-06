import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserService;

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
        User user1 = (User) session1.get(User.class, 3);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        User user2 = (User) session2.get(User.class, 3);
        session2.getTransaction().commit();
        session2.close();

        System.out.println(user1);
        System.out.println(user2);
    }
}
