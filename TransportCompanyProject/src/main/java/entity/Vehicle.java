package entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vehicleType", nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company")
    private Company company;


    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                '}';
    }
}
