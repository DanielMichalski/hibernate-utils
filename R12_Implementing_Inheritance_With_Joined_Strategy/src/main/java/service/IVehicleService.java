package service;

import entity.Vehicle;

/**
 * Author: Daniel
 */
public interface IVehicleService {
    public Vehicle get(int id);

    public void saveVehicle(Vehicle vehicle);
}
