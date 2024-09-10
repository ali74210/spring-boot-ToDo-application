package com.sat.springboottodoapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private int id;
    private String name;
    private Integer passHash;
    private String email;
    @OneToMany
    private Task task;

    public User(String name, Integer pass) {
        this.name = name;

        this.passHash = pass.hashCode();
    }
}
