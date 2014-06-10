package service;

import dao.IVehicleDao;
import entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: Daniel
 */
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleDao vehicleDao;

    @Override
    public Vehicle get(int id) {
        return vehicleDao.get(id);
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleDao.saveVehicle(vehicle);
    }
}
