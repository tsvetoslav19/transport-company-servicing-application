package entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Employee name cannot be blank!")
    @Size(max = 20, message = "Employee name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "employeePositionType", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeePositionType employeePositionType;

    @NotNull
    @Column(name = "salary")
    private double salary;

    @Column(name = "employeeQualificationType", nullable = true)
    @Enumerated(EnumType.STRING)
    private EmployeeQualificationType employeeQualificationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Transportation> transportation;

    public Employee() {

    }

    public Employee(String name, EmployeePositionType employeePositionType, double salary) {
        this.name = name;
        this.employeePositionType = employeePositionType;
        this.salary = salary;
    }

    public Employee(String name, EmployeePositionType employeePositionType, EmployeeQualificationType employeeQualificationType) {
        this.name = name;
        this.employeePositionType = employeePositionType;
        this.employeeQualificationType = employeeQualificationType;
    }

    public Employee(String name, EmployeePositionType employeePositionType, double salary, EmployeeQualificationType employeeQualificationType) {
        this.name = name;
        this.employeePositionType = employeePositionType;
        this.salary = salary;
        this.employeeQualificationType = employeeQualificationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EmployeePositionType getEmployeePositionType() {
        return employeePositionType;
    }

    public void setEmployeeQualificationType(EmployeePositionType position) {
        this.employeePositionType = position;
    }

    public EmployeeQualificationType getEmployeeQualificationType() {
        return employeeQualificationType;
    }

    public void setEmployeeQualificationType(EmployeeQualificationType employeeQualificationType) {
        this.employeeQualificationType = employeeQualificationType;
    }

    public void setTransportCompany(Company company) {
        this.company = company;
    }

    public Set<Transportation> getTransportation() {
        return transportation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeePositionType=" + employeePositionType +
                ", employeeQualificationType=" + employeeQualificationType +
                '}';
    }
}