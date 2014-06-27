package dao;

import entity.Vehicle;
import org.hibernate.Query;
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
        List vehicles = session.createQuery("from Vehicle").list();
        session.close();
        return vehicles;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllVehicleNames() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select vehicleName from Vehicle");
        return query.list();
    }

    @Override
    public List<Vehicle> getVehicleWhereIdIsBetween(int start, int end) {
        Session session = sessionFactory.openSession();

//        Query query = session.createQuery("from Vehicle where vehicleId >= ? and vehicleId <= ?");
//        query.setInteger(0, start);
//        query.setInteger(1, end);

        Query query = session.createQuery("from Vehicle where vehicleId >= :start and vehicleId <= :end");
        query.setInteger("start", start);
        query.setInteger("end", end);

        return query.list();
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
