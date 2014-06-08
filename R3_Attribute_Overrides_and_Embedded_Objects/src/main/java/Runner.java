import entity.Address;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

import java.util.Date;
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
        user.setName("User name");
        user.setJoinedDate(new Date());
        user.setDescription("Description");

        Address homeAddress = new Address();
        homeAddress.setStreet("home street name");
        homeAddress.setCity("home city name");
        homeAddress.setPinCode("home pincode");
        homeAddress.setState("home state name");
        user.setHomeAddress(homeAddress);

        Address officeAddress = new Address();
        officeAddress.setStreet("office street name");
        officeAddress.setCity("office city name");
        officeAddress.setPinCode("office pincode");
        officeAddress.setState("office state name");
        user.setOfficeAddress(officeAddress);

        userService.saveUser(user);
    }

    private static void readAllUsers(IUserService userService) {
        List<User> allUsers = userService.getAllUsers();

        for (User aUser : allUsers) {
            System.out.println(aUser);
        }
    }
}
