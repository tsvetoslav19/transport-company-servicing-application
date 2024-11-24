package entity;

public enum EmployeeQualificationType {
    NONE ("None"),
    SPECIAL("Special"),
    FLAMMABLE("Flammable"),
    TWELVEPEOPLEPLUS("12+ ppl");

    private String name;

    EmployeeQualificationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
