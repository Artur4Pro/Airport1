package models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_cmp")
    private String CompanyName;
    @Column(name = "date_found")
    private Date date;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Trip> trips;

    public Company() {
    }

    public Company(String companyName, Date date) {
        CompanyName = companyName;
        this.date = date;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", CompanyName='" + CompanyName + '\'' +
                ", date=" + date +
                ", trips=" + trips +
                '}';
    }
}
