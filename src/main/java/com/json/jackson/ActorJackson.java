package com.json.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ActorJackson {
    private String imdbId;
    private Date dateOfBirth;
    private List<String> filmography;

    // required getters and setters, default constructor
    // and field constructor details omitted
}
