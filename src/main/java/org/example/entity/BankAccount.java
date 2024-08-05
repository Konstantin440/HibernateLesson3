package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private int balanceInRubles;
    private String bonus;
    private LocalDate date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public BankAccount(int balanceInRubles, String bonus, LocalDate date) {
        this.balanceInRubles = balanceInRubles;
        this.bonus = bonus;
        this.date = LocalDate.now();
    }


}
