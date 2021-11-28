package com.example.innovance.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Column(nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "balance", length = 50)
    private Integer balance;

    @Column(name = "currency", length = 50)
    private Integer currency;

    public User(Integer id, String name, String surname, String email, Integer balance, Integer currency){
        this.id=id;
        this.name= name;
        this.surname= surname;
        this.email=email;
        this.balance= balance;
        this.currency= currency;
    }
}
