package com.sat.springboottodoapplication.DAO.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Optional;

public enum Status implements Serializable {
    @JsonProperty("DONE")
    DONE(true),
    @JsonProperty("UNDONE")
    UNDONE(false);

    boolean done;

    Status(boolean done){
        this.done = done;
    }

    @Override
    public String toString() {
        return "{}" + this.done;
    }

    @JsonValue
    public boolean value() {
        return this.done;
    }

    @JsonCreator // This is the factory method and must be static
    public static Status of(boolean b) {
        return b ? DONE : UNDONE;
    }
}
