package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToMany(mappedBy = "vehicle")
    private Set<Ride> rides;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "color")
    private String color;

    @Column(name = "capacity")
    private int capacity;

}