package entity;

public enum VehicleType {
    BUS ("Bus", 0),
    TRUCK ("Truck",5),
    TANKER ("Tanker",10);

    private String name;
    private int weight;

    VehicleType(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
