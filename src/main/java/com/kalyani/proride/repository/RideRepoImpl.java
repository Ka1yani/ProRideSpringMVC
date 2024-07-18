package com.kalyani.proride.repository;

import com.kalyani.proride.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import com.kalyani.proride.repository.interfaces.RideRepo;
import com.kalyani.proride.utility.PersistenceUtility;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class RideRepoImpl implements RideRepo {

    private final EntityManager entityManager = PersistenceUtility.getEntityManager();

    @Override
    public void save(Ride ride) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(ride);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Optional<Ride> findByID(int rideId) {
        return Optional.ofNullable(entityManager.find(Ride.class, rideId));
    }

    @Override
    public void update(Ride ride) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(ride);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteByID(int rideId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Ride ride = entityManager.find(Ride.class, rideId);
            entityManager.remove(ride);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Ride> findAll() {
        TypedQuery<Ride> findAllQuery = entityManager.createQuery("SELECT r FROM Ride r", Ride.class);
        return findAllQuery.getResultList();
    }

    @Override
    public List<Ride> findByUser(User user) {
        TypedQuery<Ride> findByUserQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.user = :user", Ride.class);
        findByUserQuery.setParameter("user", user);
        return findByUserQuery.getResultList();
    }

    @Override
    public List<Ride> findByDriver(Driver driver) {
        TypedQuery<Ride> findByDriverQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.driver = :driver", Ride.class);
        findByDriverQuery.setParameter("driver", driver);
        return findByDriverQuery.getResultList();
    }

    @Override
    public List<Ride> findByVehicle(Vehicle vehicle) {
        TypedQuery<Ride> findByVehicleQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.vehicle = :vehicle", Ride.class);
        findByVehicleQuery.setParameter("vehicle", vehicle);
        return findByVehicleQuery.getResultList();
    }

    @Override
    public List<Ride> findByStatus(RideStatus status) {
        TypedQuery<Ride> findByStatusQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.status = :status", Ride.class);
        findByStatusQuery.setParameter("status", status);
        return findByStatusQuery.getResultList();
    }

    @Override
    public List<Ride> findRecentRides(LocalDateTime fromDateTime) {
        TypedQuery<Ride> findRecentRidesQuery = entityManager.createQuery("SELECT r FROM Ride r WHERE r.createdDate >= :fromDateTime", Ride.class);
        findRecentRidesQuery.setParameter("fromDateTime", fromDateTime);
        return findRecentRidesQuery.getResultList();
    }

    private void rollback(EntityTransaction entityTransaction) {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }
}
