package com.mikescherbakov.jobinterviewbase.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "\"user\"")
@Builder
public class User {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    @Setter
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    public User() {
    }

    public User(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
