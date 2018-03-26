package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.List;

// 프로그램화해서 다양한 집계 결과물을 만들 수 있도록 reduce() 메소드 제공
public class ReductionExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 10, 30, "여자"),
                new Student("영진", 30, 30, "여자")
        );

        int sum1 = list.stream()
                .mapToInt(Student::getEnglishScore)
                .sum();

        // reduce(IntBinaryOperator op) 이용
        int sum2 = list.stream()
                .map(Student::getEnglishScore)
                .reduce((a, b) -> a+b)
                .get(); // 스트림에 요소가 없을 경우에 예외 발생

        int sum3 = list.stream()
                .map(Student::getEnglishScore)
                .reduce(0, (a, b) -> a+b); // 스트림에 요소가 없는 경우 디폴트 값 0 리턴
    }
}
