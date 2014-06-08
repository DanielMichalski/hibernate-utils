import entity.Address;
import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Daniel
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        IUserService userService = context.getBean("userService", IUserService.class);

        saveUser(userService);
    }

    private static void saveUser(IUserService userService) {
        User user = new User();
        user.setName("User name");

        Set<Address> addresses = new HashSet<Address>();

        Address homeAddress = new Address();
        homeAddress.setStreet("home street name");
        homeAddress.setCity("home city name");
        homeAddress.setPinCode("home pincode");
        homeAddress.setState("home state name");
        addresses.add(homeAddress);

        Address officeAddress = new Address();
        officeAddress.setStreet("office street name");
        officeAddress.setCity("office city name");
        officeAddress.setPinCode("office pincode");
        officeAddress.setState("office state name");
        addresses.add(officeAddress);

        user.setAddresses(addresses);

        userService.saveUser(user);
    }
}
