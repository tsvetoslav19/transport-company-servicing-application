package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.LinkedHashSet;


public class CompanyDAO {

    //Adding and editing a company
    public static void saveOrUpdateCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    //Deletion of a company
    public static void deleteTransportCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    public static Company getCompany(long id) {
        Company company;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Company WHERE id =:id").setParameter("id", id);
            company = (Company) query.getSingleResult();
            transaction.commit();
        }
        return company;
    }
    //by name and earning
    public static LinkedHashSet<Company> getCompaniesOrderedByNameAndEarnings() {
        LinkedHashSet<Company> transportCompanies;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Company ORDER BY companyName ASC, companyEarnings");
            transportCompanies = new LinkedHashSet<Company>(query.getResultList());
        }
        return transportCompanies;
    }

    public static Company getCompanyName(String companyname) {
        Company company;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Company WHERE companyName = :name").setParameter("name", companyname);
            company = (Company) query.getSingleResult();
        }

        return company;
    }

}
