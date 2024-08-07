package com.kalyani.proride.repository.interfaces;

import com.kalyani.proride.model.Driver;
import com.kalyani.proride.model.Ride;
import com.kalyani.proride.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepo {
    void save(Vehicle vehicle);

    Optional<Vehicle> findByID(int vehicleId);

    void update(Vehicle vehicle);

    void deleteByID(int vehicleId);

    List<Vehicle> findAll();

    List<Vehicle> findByMake(String make);

    List<Vehicle> findByModel(String model);

    List<Vehicle> findByYear(int year);

    List<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findByDriver(Driver driver);

    List<Ride> findRidesByVehicle(Vehicle vehicle);
}
