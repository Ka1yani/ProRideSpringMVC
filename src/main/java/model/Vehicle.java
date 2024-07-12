package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
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

    @Column(name = "is_active")
    private Boolean isActive = true;

}
