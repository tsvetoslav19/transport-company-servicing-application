package dao;

import configuration.SessionFactoryUtil;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EmployeeDAO {

    public static void saveOrUpdateEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }
    public static void deleteEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

    public static Employee getEmployee(long id) {
        Employee employee;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE id =:id").setParameter("id", id);
            employee = (Employee) query.getSingleResult();
            transaction.commit();
        }
        return employee;
    }

    public static Employee getEmployeeByName(String name) {
        Employee employee;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE name =:name").setParameter("name", name);
            employee = (Employee) query.getSingleResult();
            transaction.commit();
        }
        return employee;
    }

    public static Set<Employee> getAllEmployeesOfCompany(long companyId) {
        Set<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Employee WHERE company = " + companyId;
            employees = new HashSet<Employee>(session.createQuery(query).list());
        }
        return employees;
    }


    public static LinkedHashSet<Employee> getEmployeesOrderedByCompetenceAndSalary() {
        LinkedHashSet<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String query = "FROM Employee ORDER BY salary ASC, employeeQualificationType";
            employees = new LinkedHashSet<Employee>(session.createQuery(query).list());
        }
        return employees;
    }
}
