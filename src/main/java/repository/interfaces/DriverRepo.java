package repository.interfaces;

import model.Driver;
import model.Ride;
import model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface DriverRepo {
    void save(Driver driver);

    Optional<Driver> findByID(int driverId);

    void update(Driver driver);

    void deleteByID(int driverId);

    List<Driver> findAll();

    List<Driver> findByLicenseNumber(String licenseNumber);

    List<Driver> findByBackgroundCheckStatus(boolean backgroundCheckStatus);

    List<Ride> findRidesByDriver(Driver driver);

    List<Vehicle> findVehiclesByDriver(Driver driver);
}
