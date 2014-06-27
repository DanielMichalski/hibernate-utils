import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
//        readUsersUsingCriteria();
        readUsersUsingCriteriaRestrictions();
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

    private void readUsersUsingCriteria() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", "User2"));

        @SuppressWarnings("unchecked")
        List<User> list = (List<User>) criteria.list();

        System.out.println("User returned by criteria API:");
        for (User user : list) {
            System.out.println(user);
        }
    }

    private void readUsersUsingCriteriaRestrictions() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);

        criteria.add(Restrictions.like("name", "%User%"))
                .add(Restrictions.gt("id", 1))
                .add(Restrictions.lt("id", 5));

//        criteria.add(Restrictions.or(
//                Restrictions.between("id", 0, 1),
//                Restrictions.between("id", 3, 10)));

        @SuppressWarnings("unchecked")
        List<User> list = (List<User>) criteria.list();

        System.out.println("User returned by criteria restrictions:");
        for (User user : list) {
            System.out.println(user);
        }

    }

}
