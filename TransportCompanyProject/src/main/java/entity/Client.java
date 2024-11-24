package entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Client name cannot be blank!")
    @Size(max = 40, message = "Client name has to be with up to 40 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Client name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hasPayedTax", nullable = false)
    private boolean hasPayedTax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Transportation> transportation;

    public Client() {
    }

    public Client(String name, boolean hasPayedTax) {
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

    public boolean getHasPayedTax() {
        return hasPayedTax;
    }

    public void setHasPayedTax(boolean hasPayedTax) {
        this.hasPayedTax = hasPayedTax;
    }

    public void setTransportCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", hasPayedTax=" + hasPayedTax +
                '}';
    }
}
