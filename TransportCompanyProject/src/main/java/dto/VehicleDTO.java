package dto;

public class VehicleDTO {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                '}';
    }
}
