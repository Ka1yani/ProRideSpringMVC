package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Driver")
@PrimaryKeyJoinColumn(name = "driver_id")
public class Driver extends User {
    @OneToMany
    private Set<Ride> rides = new HashSet<>();

    @OneToMany(mappedBy = "driver")
    private Set<Vehicle> vehicles;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "background_check_status")
    private boolean backgroundCheckStatus;


}
