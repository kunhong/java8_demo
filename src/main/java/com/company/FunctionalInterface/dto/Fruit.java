package com.company.FunctionalInterface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Data
@AllArgsConstructor
public class Fruit {
    private int weight;

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase())
                .apply(weight);
    }

    public static List<Fruit> giveMeFruits(List<Integer> list, Function<Integer, Fruit> f) {
        List<Fruit> result = new ArrayList<>();
        list.stream()
                .forEach(e -> result.add(f.apply(e)));

        return result;
    }
}
