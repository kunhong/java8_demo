package com.company.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
    private static Map<String, BiConsumer<String, String>> MAP = new HashMap<>();

    static {
        MAP.put("1", ConsumerExample::foo);
        MAP.put("2", ConsumerExample::boo);
    }

    private static void foo(String a, String b) {
        System.out.println("foo " + a + " : " + b);
    }

    private static void boo(String a, String b) {
        System.out.println("boo " + a + " : " + b);
    }

    public static void print() {
    MAP.entrySet().stream()
            .forEach(entry -> {
                entry.getValue().accept("hong", "kun");
            });
    }

    public static void main(String[] args) {
        ConsumerExample.print();

        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("java");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t+u);
        biConsumer.accept("JAVA", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println("doubleConsumer = [" + d + "]");
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println("objIntConsumer = [" + t + "], " + "[" + i + "]");
        objIntConsumer.accept("JAVA", 9);
    }
}
