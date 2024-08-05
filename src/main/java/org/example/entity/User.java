package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String login;
    private String password;
    private int pinCode;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private BankAccount bankAccount;


    public User(String login, String password, int pinCode) {
        this.login = login;
        this.password = password;
        this.pinCode = pinCode;

    }
}
