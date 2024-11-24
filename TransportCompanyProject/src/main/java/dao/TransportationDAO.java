package dao;

import configuration.SessionFactoryUtil;
import entity.Transportation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TransportationDAO {

    public static void saveOrUpdateTransportation(Transportation transportation) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(transportation);
            transaction.commit();
        }
    }

    public static Set<Transportation> getAllTransportationsOfCompany(long companyId) {
        Set<Transportation> transportations;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Transportation WHERE company = " + companyId;
            transportations = new HashSet<Transportation>(session.createQuery(query).list());
        }
        return transportations;
    }

    public static LinkedHashSet<Transportation> getTransportationsOrderByDestination() {
        LinkedHashSet<Transportation> transportations;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Transportation ORDER BY endPoint";
            transportations = new LinkedHashSet<Transportation>(session.createQuery(query).list());
        }
        return transportations;
    }
}
