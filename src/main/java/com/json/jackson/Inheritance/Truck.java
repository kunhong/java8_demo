package com.json.jackson.Inheritance;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, double payloadCapacity) {
        super(make, model);
        this.payloadCapacity = payloadCapacity;
    }
}
