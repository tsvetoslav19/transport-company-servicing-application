package entity;

public enum EmployeePositionType {
    DRIVER ("Driver"),
    LOGISTICSMANAGER("Logistics Manager"),
    DISPATCHER("Dispatcher");

    private String name;

    EmployeePositionType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
