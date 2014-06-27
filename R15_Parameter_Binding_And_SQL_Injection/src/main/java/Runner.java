import entity.User;
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

    public static void main(String[] args) {
        new Runner();
    }

    public Runner() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        userService = context.getBean(UserService.class);

        saveUsers();
        readUsers();
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

    private void readUsers() {

        User user1 = userService.get(1);
        System.out.println("User with id 1:");
        System.out.println(user1);

        List<User> allUsers = userService.getAllUsers();

        System.out.println("All users:");
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

}
