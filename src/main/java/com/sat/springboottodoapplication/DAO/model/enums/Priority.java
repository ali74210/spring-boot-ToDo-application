package com.sat.springboottodoapplication.DAO.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum Priority implements Serializable {
    @JsonProperty("LOW")
    LOW(1),
    @JsonProperty("MEDIUM")
    MEDIUM(2),
    @JsonProperty("HIGH")
    HIGH(3) ;

    int n ;

    Priority(int n){
        this.n = n;
    }

    @JsonValue
    public int value() {
        return this.n;
    }

    @JsonCreator // This is the factory method and must be static
    public static Priority of(int n) {
        switch (n){
            case 2: return MEDIUM;
            case 3: return HIGH;
            default:return LOW;
        }
    }
}
