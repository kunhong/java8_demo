package com.json.jackson;

// http://www.baeldung.com/jackson-vs-gson
// https://blog.takipi.com/the-ultimate-json-library-json-simple-vs-gson-vs-jackson-vs-json/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JacksonExample {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            ActorJackson rudyYoungblood = new ActorJackson("nm2199632",
                    sdf.parse("21-09-1982"),
                    Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
//        rudyYoungblood = new ActorJackson("nm2199632",
//                sdf.parse("21-09-1982"),
//                Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
            Movie movie = new Movie("tt0472043", "Mel Gibson", Arrays.asList(rudyYoungblood));
            ObjectMapper mapper = new ObjectMapper();
            String jsonResult = mapper.writeValueAsString(movie);

            System.out.println(jsonResult);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Define map which will be converted to JSON
        Map<String,Integer> mapIdPerson  = new HashMap<>();
        mapIdPerson.put("10101001", 10101001);
        mapIdPerson.put("20202002", 20202002);
        mapIdPerson.put("30303003", 30303003);
        mapIdPerson.put("40404004", 40404004);

        //1. Convert Map to JSON
        try {
            String mapToJson = objectMapper.writeValueAsString(mapIdPerson);
            System.out.println("1. Convert Map to JSON :");
            System.out.println(mapToJson);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Map<String, Integer> salary = ImmutableMap.<String, Integer> builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();


        //1. Convert Map to JSON
        try {
            String mapToJson = objectMapper.writeValueAsString(salary);
            System.out.println("2. ImmutableMap Map to JSON :");
            System.out.println(mapToJson);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
