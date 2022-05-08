package repasotorys;

import models.Company;
import org.hibernate.Session;
import services.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class RepoCompany implements Methods<Company> {

    @Override
    public void create(Company company) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public Company read(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.find(Company.class, id);
        session.getTransaction().commit();
        session.close();
        return company;
    }
    @Override
    public void update(Long id, Company company) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Company company1 = session.find(Company.class, id);
        company1.setCompanyName(company.getCompanyName());
        company1.setDate(company.getDate());
        session.update(company1);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void delete(Long id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.find(Company.class, id);
        session.remove(company);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public List<Company> readAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Company", Company.class);
        List<Company> companies = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return companies;
    }

    public List<Company> get(int offset, int perPage, String sort) {
        Session session = SessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String sql="select c from Company c order by c."+sort+" Desc";
        Query query = session.createQuery(sql).setFirstResult(offset).setMaxResults(perPage);
        List<Company> companies = query.getResultList();
        session.close();
        return companies;
    }

}
