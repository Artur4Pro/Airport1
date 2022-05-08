package repasotorys;

import models.Address;
import org.hibernate.Session;
import services.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RepoAddress implements Methods<Address> {

    @Override
    public void create(Address address) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public Address read(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = session.find(Address.class, id);
        session.getTransaction().commit();
        session.close();
        return address;
    }
    @Override
    public void update(Long id, Address address) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Address address1 = session.find(Address.class, id);
        address1.setCity(address.getCity());
        address1.setCountry(address.getCountry());
        session.update(address1);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void delete(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = session.find(Address.class, id);
        session.remove(address);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public List<Address> readAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Address", Address.class);
        List<Address> addressList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return addressList;
    }

    public List<Address> get(int offset, int perPage, String sort) {

        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String sql="select a from Address a order by a."+sort+" Desc";
        Query query = session.createQuery(sql).setFirstResult(offset).setMaxResults(perPage);
        List<Address> addresses = query.getResultList();
        session.close();
        return addresses;
    }

}
