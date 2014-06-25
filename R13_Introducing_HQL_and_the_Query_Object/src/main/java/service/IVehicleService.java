package service;

import entity.Vehicle;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IVehicleService {
    public Vehicle get(int id);

    public List<Vehicle> getAll();

    public void saveVehicle(Vehicle vehicle);
}
