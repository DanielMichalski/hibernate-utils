package dao;

import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Daniel
 */
@Repository
public class VehicleDao implements IVehicleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Vehicle get(int id) {
        Session session = sessionFactory.openSession();
        Vehicle vehicle = (Vehicle) session.get(Vehicle.class, id);
        session.close();
        return vehicle;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Vehicle> getAll() {
        Session session = sessionFactory.openSession();
        List vehicles = session.createQuery("from entity.Vehicle").list();
        session.close();
        return vehicles;
    }


    @Override
    public void saveVehicle(Vehicle vehicle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(vehicle);
        transaction.commit();
        session.close();
    }
}
