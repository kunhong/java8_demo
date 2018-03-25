package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int englishScore;
    private int mathCore;
    private String sex;
}
