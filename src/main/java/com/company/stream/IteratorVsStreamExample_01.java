package com.company.stream;

import com.company.Student;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * Stream은 자바8부터 추가된 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자이다.
 * void forEach(Consumer<T> action)
 * Stream은 Iterator와 비슷한 역할을 하는 반복자이지만, 람다식으로 요소 처리를 제공하는 점과 내부 반복자를 사용하므로 병렬 처리가 쉽다는 점
 * 그리고 중간 처리와 최종 처리 작업을 수행하는 점에서 많은 차이를 가지고 있다.
 */
public class IteratorVsStreamExample_01 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "최영희", "김쳘수");

        List<Student> students = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자")
        );

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Stream 이용
        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name));

        Stream<Student> stream1 = students.stream();
        stream1.forEach(s -> {
            System.out.println("name = [" + s.getName() + "]");
        });

    }
}
