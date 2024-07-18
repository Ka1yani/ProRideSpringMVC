package com.kalyani.proride.repository.interfaces;

import com.kalyani.proride.model.Payment;
import com.kalyani.proride.model.PaymentStatus;
import com.kalyani.proride.model.Ride;
import com.kalyani.proride.model.User;

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
