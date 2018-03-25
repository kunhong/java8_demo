package com.company.lambda;

import com.company.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    private static List<Student> list = Arrays.asList(
            new Student("홍길동", 100, 100, "남자"),
            new Student("영희", 70, 80, "여자"),
            new Student("철수", 80, 80, "남자")
    );

    public static double avg(Predicate<Student> predicate) {
        int count = 0;
        int sum = 0;
        for (Student student : list) {
            if (predicate.test(student)) {
                count++;
                sum += student.getEnglishScore();
            }
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        double maleAvg = avg(t -> t.getSex().equals("남자"));
        System.out.println("maleAvg = [" + maleAvg + "]");
    }
}
