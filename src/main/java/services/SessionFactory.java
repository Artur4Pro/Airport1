package services;


import models.*;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
    private static org.hibernate.SessionFactory sessionFactory;

    private  SessionFactory(){}

    public static org.hibernate.SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Passenger.class);
            configuration.addAnnotatedClass(Trip.class);
            configuration.addAnnotatedClass(PassInTrip.class);
            sessionFactory=configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
