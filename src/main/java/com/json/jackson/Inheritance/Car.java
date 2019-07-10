package com.json.jackson.Inheritance;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car extends Vehicle {
    private int seatingCapacity;
    private double topSpeed;

    public Car(String make, String model, int seatingCapacity, double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }
}
