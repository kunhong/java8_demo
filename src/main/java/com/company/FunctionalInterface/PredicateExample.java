package com.company.FunctionalInterface;

import com.company.FunctionalInterface.dto.Apple;
import com.company.FunctionalInterface.dto.Fruit;
import com.company.FunctionalInterface.dto.Orange;
import com.company.FunctionalInterface.dto.Tomato;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExample {
    static Map<String, BiFunction<Integer, String, Tomato>> map = new HashMap<>();
    static {
        map.put("tomato", Tomato::new);
    }

    public static Tomato giveMeTomato(String fruit, Integer weight, String color) {
        return map.get(fruit.toLowerCase())
                .apply(weight, color);
    }

    public static void main(String[] args) {
        List<Tomato> tomatoes = Arrays.asList(
                giveMeTomato("tomato", 110, "green"),
                giveMeTomato("tomato", 200, "red"),
                giveMeTomato("tomato", 180, "green"),
                giveMeTomato("tomato", 190, "green"),
                giveMeTomato("tomato", 70, "yellow"),
                giveMeTomato("tomato", 300, "yellow"),
                giveMeTomato("tomato", 80, "green")
        );

        Predicate<Tomato> greenTomato = s -> s.getColor().equals("green");
        tomatoes.stream()
                .filter(greenTomato)
                .forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Predicate<Tomato> notGreenTomato = greenTomato.negate();
        tomatoes.stream()
                .filter(notGreenTomato)
                .forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Predicate<Tomato> grennAndHeavyTomatoOrYellow = greenTomato
                .and(t -> t.getWeight() > 110)
                .or(t -> "yellow".equals(t.getColor()));
        tomatoes.stream()
                .filter(grennAndHeavyTomatoOrYellow)
                .forEach(System.out::println);


    }
}
