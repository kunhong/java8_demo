package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample_02 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 20, 30, "여자"),
                new Student("영진", 20, 30, "여자")
        );

        // 순차 처리
        Stream<Student> stream = list.stream();
        stream.forEach(ParallelExample_02::print); // s-> ParallelExample.print(s) 와 동일

        // 병렬 처리
        // 병렬 처리란 한 가지 작업을 서브 작업으로 나누거, 서브 작업들을 분리된 스레드에서 병령적으로 처리하는 것을 말한다.
        // 병렬 처리 스트림을 이용하면 여러 개의 스레드가 요소들을 부분적으로 합하고 이 부분 합을 최종 결합해서 전체 합을 생성한다.
        Stream<Student> parallelStream = list.parallelStream();
        parallelStream.forEach(ParallelExample_02::print);
    }

    public static void print(Student student) {
        System.out.println(student.getName() + " : " + Thread.currentThread().getName());
    }
}
