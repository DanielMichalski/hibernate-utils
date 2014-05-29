import dto.Address;
import dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address homeAddress = new Address();
        homeAddress.setStreet("street");
        homeAddress.setState("state");
        homeAddress.setCity("city");
        homeAddress.setPinCode("pinCode");

        Address officeAddress = new Address();
        officeAddress.setStreet("office_street");
        officeAddress.setState("office_state");
        officeAddress.setCity("office_city");
        officeAddress.setPinCode("office_pinCode");

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Thomas");
        userDetails.setJoindedDate(new Date());
        userDetails.setDescription("descrption");
        userDetails.setHomeAddress(homeAddress);
        userDetails.setOfficeAddress(officeAddress);

        Transaction transaction = session.beginTransaction();
        session.persist(userDetails);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println(userDetails);
    }
}
