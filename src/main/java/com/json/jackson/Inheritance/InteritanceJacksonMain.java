package com.json.jackson.Inheritance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class InteritanceJacksonMain {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicles(vehicles);

        String jsonDataString = null;

        try {
            jsonDataString = mapper.writeValueAsString(serializedFleet);
            System.out.println(jsonDataString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
