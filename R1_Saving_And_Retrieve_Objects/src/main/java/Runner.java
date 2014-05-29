import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

import java.util.List;

/**
 * Author: Daniel
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        IUserService userService = context.getBean("userService", IUserService.class);


        saveUser(userService);
        readAllUsers(userService);
    }

    private static void saveUser(IUserService userService) {
        User user = new User();
        user.setId(3);
        user.setName("First user name");

        userService.saveUser(user);
    }

    private static void readAllUsers(IUserService userService) {
        List<User> allUsers = userService.getAllUsers();

        for (User aUser : allUsers) {
            System.out.println(aUser);
        }
    }
}
