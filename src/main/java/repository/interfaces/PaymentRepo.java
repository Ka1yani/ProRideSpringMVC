package repository.interfaces;

import model.Payment;
import model.PaymentStatus;
import model.Ride;
import model.User;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo {
    void save(Payment payment);

    Optional<Payment> findByID(int paymentId);

    void update(Payment payment);

    void deleteByID(int paymentId);

    List<Payment> findAll();

    List<Payment> findByUser(User user);

    List<Payment> findByRide(Ride ride);

    List<Payment> findByStatus(PaymentStatus status);
}
