package service;

import dao.IVehicleDao;
import entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleDao vehicleDao;

    @Override
    public Vehicle get(int id) {
        return vehicleDao.get(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDao.getAll();
    }

    @Override
    public List<String> getAllVehicleNames() {
        return vehicleDao.getAllVehicleNames();
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleDao.saveVehicle(vehicle);
    }
}
