package dao;

import configuration.SessionFactoryUtil;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Set;

public class VehicleDAO {
    public static void saveOrUpdateVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }
    public static void deleteVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }
    public static Vehicle getVehicle(long id) {
        Vehicle vehicle;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Vehicle WHERE id =:id").setParameter("id", id);
            vehicle = (Vehicle) query.getSingleResult();
            transaction.commit();
        }
        return vehicle;
    }

    public static Set<Vehicle> getAllVehiclesOfCompany(long companyId) {
        Set<Vehicle> vehicles;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Vehicle WHERE company = " + companyId;
            vehicles = new HashSet<Vehicle>(session.createQuery(query).list());
        }
        return vehicles;
    }
}
