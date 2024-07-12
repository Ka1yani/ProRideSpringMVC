package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.Payment;
import model.PaymentStatus;
import model.Ride;
import model.User;
import repository.interfaces.PaymentRepo;
import utility.PersistenceUtility;

import java.util.List;
import java.util.Optional;

public class PaymentRepoImpl implements PaymentRepo {

    private final EntityManager entityManager = PersistenceUtility.getEntityManager();

    // Method to save a new Payment
    public void save(Payment payment) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(payment);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    // Method to find a Payment by ID
    public Optional<Payment> findByID(int paymentId) {
        return Optional.ofNullable(entityManager.find(Payment.class, paymentId));
    }

    // Method to update a Payment
    public void update(Payment payment) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(payment);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    // Method to delete a Payment by ID
    public void deleteByID(int paymentId) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Payment payment = entityManager.find(Payment.class, paymentId);
            entityManager.remove(payment);
            entityTransaction.commit();
        } catch (Exception e) {
            rollback(entityTransaction);
            e.printStackTrace();
            throw e;
        }
    }

    // Method to find all Payments
    public List<Payment> findAll() {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
    }

    // Method to find Payments by User
    public List<Payment> findByUser(User user) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.user = :user", Payment.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    // Method to find Payments by Ride
    public List<Payment> findByRide(Ride ride) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.ride = :ride", Payment.class);
        query.setParameter("ride", ride);
        return query.getResultList();
    }

    // Method to find Payments by Status
    public List<Payment> findByStatus(PaymentStatus status) {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p WHERE p.status = :status", Payment.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    private void rollback(EntityTransaction entityTransaction) {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
        }
    }

}
