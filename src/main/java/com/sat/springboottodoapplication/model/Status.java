package com.sat.springboottodoapplication.model;

public enum Status {
    DONE(true), UNDONE(false);

    boolean done;

    Status(boolean done){
        this.done = done;
    }
}
