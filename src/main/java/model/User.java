package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int userId;

        @OneToMany(mappedBy = "user")
        private Set<Address> addresses = new HashSet<>();

        @OneToMany(mappedBy = "user")
        private Set<Payment> payments = new HashSet<>();

        @OneToMany(mappedBy = "user")
        private Set<Ride> rides;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "password")
        private String password;

        @Column(name = "profile_picture")
        private String profilePicture;

        @Column(name = "registration_date")
        private LocalDateTime registrationDate;
}
