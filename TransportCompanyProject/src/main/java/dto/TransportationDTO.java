package dto;

import java.time.LocalDate;

public class TransportationDTO {
    private long id;
    private String name;
    private double transportationPrice;
    private String startingPoint;
    private String endPoint;
    private LocalDate startDate;
    private LocalDate endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTransportationPrice() {
        return transportationPrice;
    }

    public void setTransportationPrice(double transportationPrice) {
        this.transportationPrice = transportationPrice;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "TransportationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transportationPrice=" + transportationPrice +
                ", startingPoint='" + startingPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
