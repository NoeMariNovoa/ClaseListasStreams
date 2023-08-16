package com.despegar.exercise.common;

public class Passenger {
    private final String name;
    private final PassengerType type;

    public Passenger(String name, PassengerType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PassengerType getType() {
        return type;
    }
}
