package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[] {3,4,2,5,1});
        intStream
                .sorted()
                .forEach(n -> System.out.print( n + " "));
        System.out.println();

        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 10, 30, "여자"),
                new Student("영진", 80, 30, "여자")
        );

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(t -> System.out.print( t.getEnglishScore() + " "));
        System.out.println();
    }
}
