package com.kalyani.proride.repository;

import com.kalyani.proride.model.Driver;
import com.kalyani.proride.model.Ride;
import com.kalyani.proride.model.Vehicle;
import com.kalyani.proride.utility.PersistenceUtility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import com.kalyani.proride.repository.interfaces.DriverRepo;

import java.util.List;
import java.util.Optional;

public class DriverRepoImpl implements DriverRepo {
    private final EntityManager entityManager = PersistenceUtility.getEntityManager();

    @Override
    public void save(Driver driver) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(driver);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Optional<Driver> findByID(int driverId) {
        return Optional.ofNullable(entityManager.find(Driver.class, driverId));
    }

    @Override
    public void update(Driver driver) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(driver);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteByID(int driverId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Driver driver = entityManager.find(Driver.class, driverId);
            entityManager.remove(driver);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Driver> findAll() {
        TypedQuery<Driver> query = entityManager.createQuery("SELECT d FROM Driver d", Driver.class);
        return query.getResultList();
    }

    @Override
    public List<Driver> findByLicenseNumber(String licenseNumber) {
        TypedQuery<Driver> query = entityManager.createQuery("SELECT d FROM Driver d WHERE d.licenseNumber = :licenseNumber", Driver.class);
        query.setParameter("licenseNumber", licenseNumber);
        return query.getResultList();
    }

    @Override
    public List<Driver> findByBackgroundCheckStatus(boolean backgroundCheckStatus) {
        TypedQuery<Driver> query = entityManager.createQuery("SELECT d FROM Driver d WHERE d.backgroundCheckStatus = :backgroundCheckStatus", Driver.class);
        query.setParameter("backgroundCheckStatus", backgroundCheckStatus);
        return query.getResultList();
    }

    @Override
    public List<Ride> findRidesByDriver(Driver driver) {
        return driver.getRides().stream().toList();
    }

    @Override
    public List<Vehicle> findVehiclesByDriver(Driver driver) {
        return driver.getVehicles().stream().toList();
    }

    private void rollback(EntityTransaction entityTransaction) {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }
}
