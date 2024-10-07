package com.sat.springboottodoapplication.DAO.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userTable")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String name;
    private Integer passHash;
    private String email;

    public User() {

    }

    public void setPassHash(Integer passHash) {
        this.passHash = passHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassHash() {
        return passHash;
    }

    public void setPassHash(String pass) {
        this.passHash = pass.hashCode();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
