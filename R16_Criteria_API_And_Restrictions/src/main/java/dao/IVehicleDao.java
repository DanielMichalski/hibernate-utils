package dao;

import entity.Vehicle;

import java.util.List;

/**
 * Author: Daniel
 */
public interface IVehicleDao {
    public Vehicle get(int id);

    public List<Vehicle> getAll();

    public List<String> getAllVehicleNames();

    public List<Vehicle> getVehicleWhereIdIsBetween(int start, int end);

    public void saveVehicle(Vehicle user);
}
