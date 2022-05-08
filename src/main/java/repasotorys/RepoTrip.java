package repasotorys;

import models.Trip;
import org.hibernate.Session;
import services.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RepoTrip implements Methods<Trip> {
    @Override
    public void create(Trip trip) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Trip read(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Trip trip = session.find(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return trip;
    }

    @Override
    public void update(Long id, Trip trip) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Trip trip1 = session.find(Trip.class, id);
        trip1.setPlane(trip.getPlane());
        trip1.setTimeIn(trip.getTimeIn());
        trip1.setTimeOut(trip.getTimeOut());
        trip1.setTownFrom(trip.getTownFrom());
        trip1.setTownTo(trip.getTownTo());
        session.update(trip1);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Trip trip = session.find(Trip.class, id);
        session.remove(trip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Trip> readAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Trip", Trip.class);
        List<Trip> trips = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return trips;
    }
}
