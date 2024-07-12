package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.Driver;
import model.Ride;
import model.Vehicle;
import repository.interfaces.VehicleRepo;
import utility.PersistenceUtility;

import java.util.List;
import java.util.Optional;

public class VehicleRepoImpl implements VehicleRepo {

    private final EntityManager entityManager = PersistenceUtility.getEntityManager();

    @Override
    public void save(Vehicle vehicle) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(vehicle);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Optional<Vehicle> findByID(int vehicleId) {
        return Optional.ofNullable(entityManager.find(Vehicle.class, vehicleId));
    }

    @Override
    public void update(Vehicle vehicle) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(vehicle);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteByID(int vehicleId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Vehicle vehicle = entityManager.find(Vehicle.class, vehicleId);
            entityManager.remove(vehicle);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> findAllQuery = entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
        return findAllQuery.getResultList();
    }

    @Override
    public List<Vehicle> findByMake(String make) {
        TypedQuery<Vehicle> findByMakeQuery = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.make = :make", Vehicle.class);
        findByMakeQuery.setParameter("make", make);
        return findByMakeQuery.getResultList();
    }

    @Override
    public List<Vehicle> findByModel(String model) {
        TypedQuery<Vehicle> findByModelQuery = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.model = :model", Vehicle.class);
        findByModelQuery.setParameter("model", model);
        return findByModelQuery.getResultList();
    }

    @Override
    public List<Vehicle> findByYear(int year) {
        TypedQuery<Vehicle> findByYearQuery = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.year = :year", Vehicle.class);
        findByYearQuery.setParameter("year", year);
        return findByYearQuery.getResultList();
    }

    @Override
    public List<Vehicle> findByLicensePlate(String licensePlate) {
        TypedQuery<Vehicle> findByLicensePlateQuery = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.licensePlate = :licensePlate", Vehicle.class);
        findByLicensePlateQuery.setParameter("licensePlate", licensePlate);
        return findByLicensePlateQuery.getResultList();
    }

    @Override
    public List<Vehicle> findByDriver(Driver driver) {
        TypedQuery<Vehicle> findByDriverQuery = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.driver = :driver", Vehicle.class);
        findByDriverQuery.setParameter("driver", driver);
        return findByDriverQuery.getResultList();
    }

    @Override
    public List<Ride> findRidesByVehicle(Vehicle vehicle) {
        TypedQuery<Ride> findRidesQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.vehicle = :vehicle", Ride.class);
        findRidesQuery.setParameter("vehicle", vehicle);
        return findRidesQuery.getResultList();
    }

    private void rollback(EntityTransaction entityTransaction) {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }
}
