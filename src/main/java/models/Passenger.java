package models;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_psg", length = 50)
    private String passengerName;
    @Column(name = "phone", length = 20)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "contract_address_fk"))
    private Address address;

    public Passenger() {
    }

    public Passenger(String passengerName, String phoneNumber, Address address) {
        this.passengerName = passengerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
