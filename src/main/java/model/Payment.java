package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "ride_id")
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

    public Payment(double amount, String paymentMethod, PaymentStatus status, LocalDateTime timestamp) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.timestamp = timestamp;
    }
}