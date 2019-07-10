package com.json.jackson.Inheritance;

import lombok.Data;

import java.util.List;

@Data
public class Fleet {
    private List<Vehicle> vehicles;
}
