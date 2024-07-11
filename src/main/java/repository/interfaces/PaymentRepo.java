package repository.interfaces;

import model.Payment;
import model.User;

import java.util.List;

public interface PaymentRepo {
    void save(Payment payment);
    Payment findByPaymentId(long paymentId);
    List<Payment> findAll();
}
