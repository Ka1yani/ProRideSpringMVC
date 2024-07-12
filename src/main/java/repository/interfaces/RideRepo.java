package repository.interfaces;

import model.Driver;
import model.Ride;
import model.RideStatus;
import model.Vehicle;
import model.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RideRepo {
    void save(Ride ride);

    Optional<Ride> findByID(int rideId);

    void update(Ride ride);

    void deleteByID(int rideId);

    List<Ride> findAll();

    List<Ride> findByUser(User user);

    List<Ride> findByDriver(Driver driver);

    List<Ride> findByVehicle(Vehicle vehicle);

    List<Ride> findByStatus(RideStatus status);

    List<Ride> findRecentRides(LocalDateTime fromDateTime);
}
