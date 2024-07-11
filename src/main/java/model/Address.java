package model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToMany(mappedBy = "pickupLocation")
    private Set<Ride> pickupRides;

    @OneToMany(mappedBy = "dropOffLocation")
    private Set<Ride> dropOffRides;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "location_type")
    private String locationType;

}
