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

    private IUserService userService;

    public static void main(String[] args) {
        new Runner();
    }

    public Runner() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        userService = context.getBean("userService", IUserService.class);

        saveUser();
        readUser();
    }

    private void readUser() {
        User user = userService.get(1);
        System.out.println(user);
        System.out.println("addresses size: " + user.getAddresses().size());
    }

    private void saveUser() {
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
