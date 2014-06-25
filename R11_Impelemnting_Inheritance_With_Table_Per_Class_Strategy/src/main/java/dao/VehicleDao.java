package dao;

import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void saveVehicle(Vehicle vehicle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(vehicle);
        transaction.commit();
        session.close();
    }
}
