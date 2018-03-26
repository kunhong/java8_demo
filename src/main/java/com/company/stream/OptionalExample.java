package com.company.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

// Optional, OptionalDouble, OptionalInt, OptionalLong
// 단순히 집계 값만 저장하는 것이 아니라, 집계 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있고
// 집계 값을 처리하는 Consumer도 등록할 수 있다.
public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        /* // 예외 발생 (NoSuchElementException)
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
                */

        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (optional.isPresent())
            System.out.println(optional.getAsDouble());
        else
            System.out.println("평균 : 0.0");

        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0); // 값이 지정되어 있지 않은 경우 디폴트 값 지정

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a-> System.out.println(a)); // 값이 저장되어 있을 경우 Consumer에서 처리


    }
}
