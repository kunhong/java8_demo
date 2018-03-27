package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴
*
*      ---> A  --> C
* B A                   ----> D C
*      ---> B  --> D
*
* map, mapToDouble, mapToint, mapToObj
*
* */
public class MapExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 20, 30, "여자"),
                new Student("영진", 20, 30, "여자")
        );

        list.stream()
                .mapToInt(Student::getEnglishScore)
                .forEach(System.out::println);
//        90
//        20
//        20
//        20

        List<String> names = list.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        names.stream()
                .forEach(System.out::println);
    }
}
