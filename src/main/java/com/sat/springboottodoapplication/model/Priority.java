package com.sat.springboottodoapplication.model;

public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3) ;

    int n ;

    Priority(int n){
        this.n = n;
    }
}
