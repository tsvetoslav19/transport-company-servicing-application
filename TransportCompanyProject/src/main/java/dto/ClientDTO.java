package dto;

public class ClientDTO {
    private long id;
    private String name;
    private boolean hasPayedTax;

    public ClientDTO(long id, String name, boolean hasPayedTax) {
        this.id = id;
        this.name = name;
        this.hasPayedTax = hasPayedTax;
    }

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

    public boolean isHasPayedTax() {
        return hasPayedTax;
    }

    public void setHasPayedTax(boolean hasPayedTax) {
        this.hasPayedTax = hasPayedTax;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasPayedTax=" + hasPayedTax +
                '}';
    }
}
