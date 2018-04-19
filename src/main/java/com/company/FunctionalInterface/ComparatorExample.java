package com.company.FunctionalInterface;

import com.company.FunctionalInterface.dto.Apple;
import com.company.FunctionalInterface.dto.Fruit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    static List<Integer> weights = Arrays.asList(7, 3, 4, 10);

    public static void main(String[] args) {
        List<Fruit> fruits = Fruit.giveMeFruits(weights, Apple::new);

        fruits.add(Fruit.giveMeFruit("orange", 100));
        fruits.stream()
                .forEach(fruit -> System.out.println(fruit.getWeight()));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Comparator<Fruit> c = Comparator.comparing(Fruit::getWeight);
        //fruits.sort(c);
        fruits.sort(Comparator.comparing(Fruit::getWeight));
        fruits.stream()
                .forEach(fruit -> System.out.println(fruit.getWeight()));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        fruits.sort(c.reversed());
        fruits.stream()
                .forEach(fruit -> System.out.println(fruit.getWeight()));

        /*
        *
        * fruits.sort(Comparator.comparing(Fruit::getWeight)
        *               .reverse()
        *               .thenComparing(Fruit::getCountry); // 두 과일 무게가 같으면 국가별로 정렬
        *
        *
        * */

    }
}
