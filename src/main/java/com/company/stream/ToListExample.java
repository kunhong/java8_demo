package com.company.stream;

import com.company.data.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*  수집 (Collection)
* 스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect()를 제공
* 이 메소드를 이용하면 필요한 요소만 컬렉션으로 담을 수 있고, 요소들을 그룹핑한 후 집계(리덕션)할 수 있다.
* R collect(Collector<T,A,R> collector)
* : T 요소를 A 누적기가 R에 저장한다는 의미
*
* */
public class ToListExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90, 96, "남자"),
                new Student("영희", 20, 30, "여자"),
                new Student("철수", 10, 30, "여자"),
                new Student("영진", 20, 30, "여자")
        );

        // 리턴값인 Colletor를 보면 A(누적기)가 ? 로 되어 있는데, 이것은 Collector가 R(컬렉션)에 T(요소)를 저장하는 방법을 알고 있어
        // A(누적기)가 필요 없기 때문이다.

/*
        Stream<Student> totalStream = list.stream();
        Stream<Student> femaleStream = totalStream.filter(s->s.getSex().equals("여자"));
        Collector<Student, ?, List<Student>> collector = Collectors.toList(); // 리스트에 Student를 수집하는 Collector를 얻는다.
        List<Student> femaleList = femaleStream.collect(collector);
*/
        List<Student> femaleList = list.stream()
                .filter(s->s.getSex().equals("여자"))
                .collect(Collectors.toList());
        femaleList.stream()
                .forEach(s-> System.out.println(s.getName()));

        // 여학생들만 묶어 HashSet 생성
        Set<Student> femaleSet = list.stream()
                .filter(s->s.getSex().equals("여자"))
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.stream()
                .forEach(s-> System.out.println(s.getName()));



    }
}
