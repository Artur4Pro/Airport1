package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(length = 50)
    private String country;
    @Column(length = 50)
    private String city;

    @OneToMany(mappedBy = "address")
    private Set<Passenger> passenger;

    public Address() {
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return Id;
    }

    public Set<Passenger> getPassenger() {
        return passenger;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", passenger=" + passenger +
                '}';
    }
}
