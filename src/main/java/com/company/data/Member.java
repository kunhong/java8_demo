package com.company.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    public static final int MALE = 0;
    public static final int FEMAIL = 1;

    private String name;
    private int sex;
    private int age;
}
