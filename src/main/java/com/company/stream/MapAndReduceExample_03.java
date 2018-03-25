package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 스트림은 컬렉션의 요서에 대해 중간 처리와 최종 처리를 수행할 수 있는데, 중간 처리에서는 매핑, 필터링, 정렬을 수행하고 최종 처리에서는 반복, 키운팅, 평균, 총합 등의 집계 처리를 수행한다.
public class MapAndReduceExample_03 {
    public static int sum = 0;
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 20, 30, "여자"),
                new Student("영진", 20, 30, "여자")
        );

        double avg = list.stream()
                // 중간 처리 (학생 객체의 점수로 매핑
                .mapToInt(Student::getEnglishScore)
                // 최종 처리 (평균 점수)
                .average()
                .getAsDouble();

        System.out.println("평균 점수 = [" + avg + "]");



        IntStream stream = IntStream.rangeClosed(1, 100); // range를 사용하면 2번 째 매개변수는 포함 안함
        stream.forEach(a -> sum += a);
        System.out.println("sum = [" + sum  + "]");



    }
}
