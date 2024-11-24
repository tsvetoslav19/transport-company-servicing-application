import dao.*;
import entity.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class main {

    public static void main(String[] args) throws IOException {

        Company company = new Company("TransportCompany");
        CompanyDAO.saveOrUpdateCompany(company);

        Employee employeeOne = new Employee("EmployeeTransportCompanyOne", EmployeePositionType.DRIVER, 4000, EmployeeQualificationType.FLAMMABLE);
        employeeOne.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        Employee employeeTwo = new Employee("EmployeeTransportCompanyTwo", EmployeePositionType.DRIVER, 5000, EmployeeQualificationType.TWELVEPEOPLEPLUS);
        employeeTwo.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        Employee employeeThree = new Employee("EmployeeTransportCompanyThree", EmployeePositionType.LOGISTICSMANAGER, 6000);
        employeeThree.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        //add employees
        company.addEmployee(employeeOne);
        company.addEmployee(employeeTwo);
        company.addEmployee(employeeThree);
        //save in db
        EmployeeDAO.saveOrUpdateEmployee(employeeOne);
        EmployeeDAO.saveOrUpdateEmployee(employeeTwo);
        EmployeeDAO.saveOrUpdateEmployee(employeeThree);
        //delete employee
        //EmployeeDAO.deleteEmployee();

        Client clientOne = new Client("ClientOne", true);
        Client clientTwo = new Client("ClientTwo", false);
        Client clientThree = new Client("ClientThree", true);
        clientOne.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        clientTwo.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        clientThree.setTransportCompany(CompanyDAO.getCompany(company.getId()));
        //add clients
        company.addClient(clientOne);
        company.addClient(clientTwo);
        company.addClient(clientThree);
        //save in db
        ClientDAO.saveOrUpdateClient(clientOne);
        ClientDAO.saveOrUpdateClient(clientTwo);
        ClientDAO.saveOrUpdateClient(clientThree);
        //delete client
        //ClientDAO.deleteClient();

        GoodsType inanimate = GoodsType.INANIMATE;
        inanimate.setAmount(5000);
        GoodsType animate = GoodsType.ANIMATE;
        animate.setAmount(13);

        Transportation transportationOne = new Transportation("ClientOne - Shipment One",
                7000, "Sofia", "Blagoevgrad",
                LocalDate.of(2023, 7, 19), LocalDate.of(2023, 11, 18), inanimate);
        Transportation transportationTwo = new Transportation("ClientThree - Shipment One",
                12000, "Plovdiv", "Sandanski",
                LocalDate.of(2023, 4, 12), LocalDate.of(2023, 6, 30), animate);

        transportationOne.setCompany(CompanyDAO.getCompany(company.getId()));
        transportationTwo.setCompany(CompanyDAO.getCompany(company.getId()));

        transportationOne.setClient(ClientDAO.getClient(1));
        transportationTwo.setClient(ClientDAO.getClient(3));
        company.addTransportation(transportationOne, 1);
        company.addTransportation(transportationTwo, 3);

        CompanyDAO.saveOrUpdateCompany(company);
        //save in db
        TransportationDAO.saveOrUpdateTransportation(transportationOne);
        TransportationDAO.saveOrUpdateTransportation(transportationTwo);

        Vehicle transportVehicleOne = new Vehicle(VehicleType.TRUCK);
        Vehicle transportVehicleTwo = new Vehicle(VehicleType.TANKER);
        Vehicle transportVehicleThree = new Vehicle(VehicleType.BUS);

        transportVehicleOne.setCompany(CompanyDAO.getCompany(company.getId()));
        transportVehicleTwo.setCompany(CompanyDAO.getCompany(company.getId()));
        transportVehicleThree.setCompany(CompanyDAO.getCompany(company.getId()));
        //add transport vehicles
        company.addTransportVehicle(transportVehicleOne);
        company.addTransportVehicle(transportVehicleTwo);
        company.addTransportVehicle(transportVehicleThree);
        //save in db
        VehicleDAO.saveOrUpdateVehicle(transportVehicleOne);
        VehicleDAO.saveOrUpdateVehicle(transportVehicleTwo);
        VehicleDAO.saveOrUpdateVehicle(transportVehicleThree);
        //delete vehicle
        //VehicleDAO.deleteVehicle();
        //write to file
        company.printAllCompanyInfo();
        company.writeTransportationDataToFile(company.getTransportationDetails());
        company.readTransportationDataFromFile("transportations.txt");
        //Companies Ordered By Name And Earnings in ascending order
        AtomicInteger i = new AtomicInteger(1);
        LinkedHashSet<Company> set = CompanyDAO.getCompaniesOrderedByNameAndEarnings();
        set.forEach(e -> System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ Companies Ordered By Name And Earnings in ascending order: "
                + i.getAndIncrement()+"."+ e.getCompanyName() + "~~~~~~~~~~~~~~~~~~~~~~~~~"));
        //Transportation Orders By Destination
        AtomicInteger j = new AtomicInteger(1);
        LinkedHashSet<Transportation> set1 = TransportationDAO.getTransportationsOrderByDestination();
        set1.forEach(e1 -> System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ Transportations Order By Destination: "
                + j.getAndIncrement()+"."+ e1.getEndPoint() + "~~~~~~~~~~~~~~~~~~~~~~~~~"));
        //Employees Ordered By Salary And Qualification Type in ascending order
        AtomicInteger k = new AtomicInteger(1);
        LinkedHashSet<Employee> set2 = EmployeeDAO.getEmployeesOrderedByCompetenceAndSalary();
        set2.forEach(e1 -> System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ Employees Ordered By Salary And Qualification Type in ascending order: "
                + k.getAndIncrement()+"."+ e1.getName() + "~~~~~~~~~~~~~~~~~~~~~~~~~"));

    }
}
