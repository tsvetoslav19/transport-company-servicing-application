package dao;

import configuration.SessionFactoryUtil;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.HashSet;
import java.util.Set;

public class ClientDAO {

    public static void saveOrUpdateClient(Client client) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

    public static void deleteClient(Client client) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }

    public static Client getClient(long id) {
        Client client;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Client WHERE id =:id").setParameter("id", id);
            client = (Client) query.getSingleResult();
            transaction.commit();
        }
        return client;
    }

    public static Set<Client> getAllClientsOfCompany(long companyId) {
        Set<Client> clients;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Client WHERE company = " + companyId;
            clients = new HashSet<Client>(session.createQuery(query).list());
        }
        return clients;
    }
}
