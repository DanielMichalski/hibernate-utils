import entity.User;
import entity.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Daniel
 */
public class Runner {

    private IUserService userService;

    public Runner() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        userService = context.getBean("userService", IUserService.class);

        saveUser();
        readUser();
    }

    public static void main(String[] args) {
        new Runner();
    }

    private void saveUser() {
        User user = new User();
        user.setName("User name");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        user.setVehicles(vehicles);

        userService.saveUser(user);
    }

    private void readUser() {
        User user = userService.get(1);
        System.out.println(user);
    }
}
