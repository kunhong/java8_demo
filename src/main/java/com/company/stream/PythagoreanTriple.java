package com.company.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {
    public static void main(String[] args) {
        Stream<Integer> integerStream = IntStream.rangeClosed(1, 2).boxed();
        integerStream.forEach(System.out::println); // 1 2

        int a = 3;
        Stream<int[]> intArrStream = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .boxed()
                .map(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)});

        //System.out.println(intArrStream.count()); // 1
        //intArrStream.forEach(v -> System.out.println(v.length)); // 3
        intArrStream.forEach(v -> System.out.println(v[2])); // v = {3,4,5}



        Stream<int[]> pythagoreanTripes = IntStream.rangeClosed(1, 100)
                .boxed() // rangeClose 로 반환된 IntStream을 Stream<Integer> 로 복원
                .flatMap(i ->
                        IntStream.rangeClosed(i, 100)
                        .filter(b -> Math.sqrt(i*i + b*b) % 1 == 0)
                        .mapToObj(b -> new int[]{i, b, (int) Math.sqrt(i*i + b*b)})
                );

        pythagoreanTripes.forEach(t -> System.out.println(Arrays.toString(t)));

        Stream<double[]> pythagoreanTripes2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(x -> IntStream.rangeClosed(x, 100)
                .mapToObj(y -> new double[] {x, y, Math.sqrt(x*x + y*y)})
                        .filter(t -> t[2] % 1 == 0));

        pythagoreanTripes2.limit(3)
                .forEach(t -> System.out.println(Arrays.toString(t)));

    }
}
