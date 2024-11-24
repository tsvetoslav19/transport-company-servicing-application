package entity;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transportation")
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "transportationprice", nullable = false)
    private double transportationPrice;

    @NotNull
    @Column(name = "startingpoint", nullable = false)
    private String startingPoint;

    @NotNull
    @Column(name = "endpoint", nullable = false)
    private String endPoint;

    @NotNull
    @Column(name = "startdate", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "enddate", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(name = "goodstype", nullable = false)
    @Enumerated(EnumType.STRING)
    private GoodsType goodsType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    public Transportation() {
    }

    public Transportation(String name, double transportationPrice, String startingPoint,
                          String endPoint, LocalDate startDate, LocalDate endDate, GoodsType goodsType) {
        this.name = name;
        this.transportationPrice = transportationPrice;
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goodsType = goodsType;
    }

    public double getTransportationPrice() {
        return transportationPrice;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEndPoint() {
        return endPoint;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "name='" + name + '\'' +
                ", transportationPrice=" + transportationPrice +
                ", startingPoint='" + startingPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", goodsType=" + goodsType +
                '}' + "\n";
    }
}
