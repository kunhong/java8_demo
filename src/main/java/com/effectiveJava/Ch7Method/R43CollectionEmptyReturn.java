package com.effectiveJava.Ch7Method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class R43CollectionEmptyReturn {
    private static List<Integer> list = Collections.emptyList();

    public static void main(String[] args) {
        System.out.println("list.size() = [" + list.size() + "]");
        try {
            list.add(100);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        list.stream()
                .mapToInt(Integer::intValue)
                .forEach(System.out::println);

        list.stream()
                .map(Integer::intValue)
                .reduce(0, (a, b) -> a+b);

        list = list.stream()
                .map(i -> i + 1)
                .collect(Collectors.toList());

        System.out.println("list.size() = [" + list.size() + "]");

        list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        int sum = list.stream()
                .map(Integer::intValue)
                .reduce(0, (a, b) -> a+b);


        list.stream()
                .mapToInt(Integer::intValue)
                .forEach(System.out::println);

        System.out.println("sum = [" + sum + "]");

        list = list.stream()
                .map(i -> i + 1)
                .collect(Collectors.toList());


        list.stream()
                .mapToInt(Integer::intValue)
                .forEach(System.out::println);
    }
}
