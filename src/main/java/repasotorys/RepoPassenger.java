package repasotorys;

import models.Passenger;
import org.hibernate.Session;
import services.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RepoPassenger implements Methods<Passenger> {

    @Override
    public void create(Passenger passenger) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Passenger read(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Passenger passenger = session.find(Passenger.class,id);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    @Override
    public void update(Long id, Passenger passenger) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Passenger passenger1 = session.find(Passenger.class,id);
        passenger1.setPassengerName(passenger.getPassengerName());
        passenger1.setPhoneNumber(passenger.getPhoneNumber());
        session.update(passenger1);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Passenger passenger = session.find(Passenger.class,id);
        session.remove(passenger);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Passenger> readAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Passenger",Passenger.class);
        List<Passenger> passengers = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return passengers;
    }
}
