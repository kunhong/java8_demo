package com.company.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private int englishScore;
    private int mathCore;
    private String sex;

    @Override
    public int compareTo(Student o) {
        return Integer.compare(englishScore, o.englishScore);
    }
}
