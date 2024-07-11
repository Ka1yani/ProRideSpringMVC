package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

enum PaymentStatus {PENDING, SUCCESSFUL, FAILED}

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name ="ride_id")
    private Ride ride;


    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}