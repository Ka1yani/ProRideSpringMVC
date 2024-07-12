package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int userId;

        @OneToMany(mappedBy = "user")
        private Set<Address> addresses = new HashSet<>();

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Payment> payments = new HashSet<>();

        @OneToMany(mappedBy = "user")
        private Set<Ride> rides = new HashSet<>();

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password")
        private String password;

        @Column(name = "registration_date")
        private LocalDateTime registrationDate;

        @Column(name = "is_active")
        private Boolean isActive = true;

        public void addPayment(Payment payment) {
                payment.setUser(this);
                payments.add(payment);
        }

        public void removePayment(Payment payment) {
                payments.remove(payment);
                payment.setUser(null);
        }

        public User(String name, String email, String phoneNumber, String password, LocalDateTime registrationDate) {
                this.name = name;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.password = password;
                this.registrationDate = registrationDate;
        }
}
