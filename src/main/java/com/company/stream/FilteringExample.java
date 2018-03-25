package com.company.stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신민철", "신용권");

        // 중복 제거
        names.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        // 필터링
        names.stream()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
        System.out.println();

        // 중복 제거후 필터링
        names.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
        System.out.println();

    }
}
