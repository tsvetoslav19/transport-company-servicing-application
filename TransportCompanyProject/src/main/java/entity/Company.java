package entity;

import dao.EmployeeDAO;
import jakarta.validation.constraints.*;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Company name has to start with capital letter!")
    @Column(name = "companyname", unique = true)
    private String companyName;

    @NotNull
    @Column(name = "companyearnings")
    private double companyEarnings;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private Set<Transportation> transportations;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Client> clients;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public Company() {
        this.companyEarnings = 0;
        this.transportations = new HashSet<Transportation>();
        this.clients = new HashSet<Client>();
        this.employees = new HashSet<Employee>();
        this.vehicles = new HashSet<Vehicle>();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.companyEarnings = 0;
        this.transportations = new HashSet<Transportation>();
        this.clients = new HashSet<Client>();
        this.employees = new HashSet<Employee>();
        this.vehicles = new HashSet<Vehicle>();
    }

    public void addTransportation(Transportation transportation, long driverId) {
        //500 base fee required per transportation
        if (transportation.getTransportationPrice() > 500) {
            transportation.setEmployee(addDriverToTransportation(driverId));
            this.transportations.add(transportation);
            this.setCompanyEarnings(this.getCompanyEarnings() + transportation.getTransportationPrice());
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~Invalid transportation price (less than min-500) transportation will not be added!~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public void addClient(Client client) {
        if (client.getHasPayedTax()) {
            clients.add(client);
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~Client cannot be added -> hasn't payed his tax yet!~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public Employee addDriverToTransportation(long driverId) {
        Employee driver = EmployeeDAO.getEmployee(driverId);
        if (driver.getEmployeePositionType().equals(EmployeePositionType.DRIVER)) {
            return driver;
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~EMPLOYEE CANNOT BE ADDED TO TRANSPORTATION! (NOT A DRIVER), NULL RETURNED~~~~~~~~~~~~~~~~~~~~~~~~~");
            return null;
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTransportVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void printAllCompanyInfo() {

        System.out.println(" Transportations ");
        this.transportations.forEach(System.out::println);
        System.out.println(" Clients ");
        this.clients.forEach(System.out::println);
        System.out.println(" Employees ");
        this.employees.forEach(System.out::println);
        System.out.println(" Vehicles ");
        this.vehicles.forEach(System.out::println);
    }

    public double getCompanyEarnings() {
        return companyEarnings;
    }

    public void setCompanyEarnings(double companyEarnings) {
        this.companyEarnings = companyEarnings;
    }

    public void setTransportations(Set<Transportation> transportations) {
        this.transportations = transportations;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setTransportVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getTransportationDetails() {
        String str = " Transportations for " + this.getCompanyName() +"\n";
        for (Transportation t : this.transportations ) {
            str += t.toString();
        }

        return str;
    }

    public void writeTransportationDataToFile(String transportationData) {
        try {
            FileWriter fileWriter = new FileWriter("transportations.txt");
            fileWriter.write(transportationData);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readTransportationDataFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
