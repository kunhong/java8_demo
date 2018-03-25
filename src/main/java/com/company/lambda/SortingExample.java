package com.company.lambda;


import com.company.data.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int [] {5,3,4,1,2});
        intStream
                .sorted()
                .forEach(System.out::println);


        List<Student> list = Arrays.asList(
                new Student("홍길동", 100, 100, "남자"),
                new Student("영희", 70, 80, "여자"),
                new Student("철수", 80, 80, "남자"));

        list.stream()
                .sorted()
                .forEach(System.out::println);

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
