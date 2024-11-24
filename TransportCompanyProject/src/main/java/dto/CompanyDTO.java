package dto;

public class CompanyDTO {
    private long id;
    private String companyName;
    private double companyEarnings;

    public CompanyDTO(long id, String companyName, double companyEarnings) {
        this.id = id;
        this.companyName = companyName;
        this.companyEarnings = companyEarnings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCompanyEarnings() {
        return companyEarnings;
    }

    public void setCompanyEarnings(double companyEarnings) {
        this.companyEarnings = companyEarnings;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyEarnings=" + companyEarnings +
                '}';
    }
}
