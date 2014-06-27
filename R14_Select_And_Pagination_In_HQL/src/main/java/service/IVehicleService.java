package service;

import entity.Vehicle;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IVehicleService {
    public Vehicle get(int id);

    public List<Vehicle> getAll();

    public List<String> getAllVehicleNames();

    public void saveVehicle(Vehicle vehicle);
}
