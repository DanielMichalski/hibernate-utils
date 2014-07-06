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
        Session session = sessionFactory.openSession();

        User user = (User) session.get(User.class, 3);
        user.setName("New user name");
        User user2 = (User) session.get(User.class, 3);

        System.out.println(user);
        System.out.println(user2);

        session.close();
    }
}
