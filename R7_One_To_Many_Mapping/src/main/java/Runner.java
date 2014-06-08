import entity.User;
import entity.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

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

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        user.setVehicle(vehicle);

        userService.saveUser(user);
    }

    private void readUser() {
        User user = userService.get(1);
        System.out.println(user);
    }
}
