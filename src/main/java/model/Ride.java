package model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

enum RideStatus {REQUESTED, ACCEPTED, ONGOING, COMPLETED, CANCELLED}

@Data
@Entity
@Table(name = "Ride")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ride_id")
    private int rideId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Address pickupLocationId;

    @ManyToOne
    @JoinColumn(name = "drop_off_location_id")
    private Address dropOffLocationId;


    @Column(name = "pickup_time")
    private LocalDateTime pickUpTime;

    @Column(name = "drop_off_time")
    private LocalDateTime dropOffTime;

    @Column(name = "fare")
    double fare;

    @Column(name = "payment_method")
    String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RideStatus status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany
    private Set<Payment> payments = new HashSet<>();
}
