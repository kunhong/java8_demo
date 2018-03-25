package com.company.lambda;

import com.company.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionalExample1 {
    private static List<Student> list = Arrays.asList(
        new Student("홍길동", 90, 96),
        new Student("영희", 20, 30)
    );

    public static void printString(Function<Student, String> function) {
        for (Student student : list) {
            System.out.println(function.apply(student));
        }
    }

    public static void printInt(ToIntFunction<Student> function) {
        for (Student student : list) {
            System.out.println(function.applyAsInt(student));
        }
    }

    public static void main(String[] args) {
        printString(t -> t.getName());
        printInt(t -> t.getEnglishScore());
    }
}
