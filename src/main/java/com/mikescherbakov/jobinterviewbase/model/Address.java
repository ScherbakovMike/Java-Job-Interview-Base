package com.mikescherbakov.jobinterviewbase.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "address")
@Builder
public class Address {

    public Address() {
    }

    public Address(Long id, String street, User user) {
        this.id = id;
        this.street = street;
        this.user = user;
    }

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String street;
    @Setter
    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;
}
