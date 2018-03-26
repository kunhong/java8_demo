package com.company.stream;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        long count = Arrays.stream(new int[] {1,2,3,4,5})
                .filter(n -> n%2 == 0)
                .count();
        System.out.println("count = [" + count + "]"); // 2

        long sum = Arrays.stream(new int[] {1,2,3,4,5})
                .filter(n -> n%2 == 0)
                .sum(); // average , max, min // 6
        System.out.println("sum = [" + sum + "]");

        int first = Arrays.stream(new int[] {1,2,3,4,5})
                .filter(n -> n%3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("first = [" + first + "]"); // 3

    }
}
