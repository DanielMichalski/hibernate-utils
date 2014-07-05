import entity.FourWheeler;
import entity.TwoWheeler;
import entity.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IVehicleService;

/**
 * Author: Daniel
 */
public class Runner {

    private IVehicleService vehicleService;

    public Runner() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        vehicleService = context.getBean("vehicleService", IVehicleService.class);

        saveVehicle();
        readVehicle();
    }

    public static void main(String[] args) {
        new Runner();
    }

    private void saveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike steering handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche steering wheel");

        vehicleService.saveVehicle(vehicle);
        vehicleService.saveVehicle(bike);
        vehicleService.saveVehicle(car);
    }

    private void readVehicle() {
        Vehicle vehicle1 = vehicleService.get(1);
        Vehicle vehicle2 = vehicleService.get(2);
        Vehicle vehicle3 = vehicleService.get(3);

        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(vehicle3);
    }
}
