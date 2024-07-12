package repository.interfaces;

import model.Address;

import java.util.List;

public interface AddressRepo {
    void save(Address address);
    Address findById(int id);
    List<Address> findAll();
    void update(Address address);
    void delete(Address address);

    // Custom methods
    List<Address> findByUserId(int userId);
    List<Address> findByDriverId(int driverId);
    List<Address> findByCity(String city);
    List<Address> findByLocationType(String locationType);
}
