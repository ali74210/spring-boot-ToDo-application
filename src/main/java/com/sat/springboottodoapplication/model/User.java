package com.sat.springboottodoapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private int id;
    private String name;
    private Integer passHash;
    private String email;

    public User(String name, Integer pass) {
        this.name = name;
        this.passHash = pass.hashCode();
    }

    public User() {

    }
}
