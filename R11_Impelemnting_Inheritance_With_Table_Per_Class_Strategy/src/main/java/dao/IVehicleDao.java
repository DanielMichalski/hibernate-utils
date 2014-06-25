package dao;

import entity.Vehicle;

/**
 * Author: Daniel
 */
public interface IVehicleDao {
    public Vehicle get(int id);

    public void saveVehicle(Vehicle user);
}
