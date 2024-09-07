package com.sat.springboottodoapplication.model;

public class User {
    private int id;
    private String name;
    private String pass;
    private String email;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
