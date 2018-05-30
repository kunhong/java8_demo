package com.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Lombok_GetterSetter {
    @Getter @Setter private int age = 10;
    @Setter(AccessLevel.PROTECTED) private String name;

//    protected void setName(String name) {
//        this.name = name;
//    }

    @Getter(AccessLevel.NONE) private int grade = 1; // getGrade() 가 없음

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}
