package models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    private long tripNumber;
    @Column(length = 50)
    private String plane;
    @Column(name = "town_from", length = 50)
    private String townFrom;
    @Column(name = "town_to", length = 50)
    private String townTo;
    @Column(name = "time_out",length = 50)
    private Time timeOut;
    @Column(name = "time_in",length = 50)
    private Time timeIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "pass_in_trip", joinColumns = @JoinColumn(referencedColumnName = "tripNumber", name = "tripNumber"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "passengerID"))
    private Set<Passenger> passengers;

    public Trip() {
    }

    public Trip(long tripNo, String plane, String townFrom, String townTo, Time timeOut, Time timeIn, Company company) {
        this.tripNumber = tripNo;
        this.plane = plane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
        this.company = company;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public long getTripNo() {
        return tripNumber;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNo=" + tripNumber +
                ", plane='" + plane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut=" + timeOut +
                ", timeIn=" + timeIn +
                ", company=" + company +
                ", passengers=" + passengers +
                '}';
    }
}
