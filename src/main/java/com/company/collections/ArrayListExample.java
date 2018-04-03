package com.company.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Servelet/JSP");

        List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,9);
        lst.stream()
                .reduce((a, b) -> {
                    System.out.println("a, b = [" + a  +", " + b + "]");
                    return a + b;
                });

//        a, b = [1, 2]
//        a, b = [3, 3]
//        a, b = [6, 4]
//        a, b = [10, 5]
//        a, b = [15, 6]
//        a, b = [21, 7]
//        a, b = [28, 8]
//        a, b = [36, 9]
    }
}
