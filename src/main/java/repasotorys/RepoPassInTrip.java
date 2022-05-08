package repasotorys;

import models.PassInTrip;
import org.hibernate.Session;
import services.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RepoPassInTrip implements Methods<PassInTrip> {

    @Override
    public void create(PassInTrip passInTrip) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(passInTrip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PassInTrip read(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        PassInTrip passInTrip = session.find(PassInTrip.class, id);
        session.getTransaction().commit();
        session.close();
        return passInTrip;
    }

    @Override
    public void update(Long id, PassInTrip passInTrip) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        PassInTrip passInTrip1 = session.find(PassInTrip.class, id);
        passInTrip1.setPlace(passInTrip.getPlace());
        passInTrip1.setPassInTripId(passInTrip.getPassInTripId());
        session.update(passInTrip1);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        PassInTrip passInTrip = session.find(PassInTrip.class, id);
        session.remove(passInTrip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PassInTrip> readAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from pass_in_trip", PassInTrip.class);
        List<PassInTrip> passInTrips = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return passInTrips;
    }
}
