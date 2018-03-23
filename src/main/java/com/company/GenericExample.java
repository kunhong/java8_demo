package com.company;

import com.company.generic.Box;
import com.company.generic.Pair;
import com.company.generic.Product;
import com.company.generic.Util;

public class GenericExample {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(100); // 자동 boxing
        System.out.println("box1.get() = [" + box1.get() + "]"); // box1.get() = [100]

        Product<Box<Integer>, String> product = new Product<>();
        product.setKind(box1);
        product.setModel("박스");
        System.out.println("Box = [" + product.getKind().get() + "]"); // Box = [100]
        System.out.println("String = [" + product.getModel() + "]"); // String = [박스]

        Box<String> box = Util.boxing("utilBoxing");
        System.out.println("Util.boxing = [" + box.get() + "]"); // Util.boxing = [utilBoxing]

        Pair<Integer, String> p1 = new Pair<>(1, "사과");
        Pair<Integer, String> p2 = new Pair<>(1, "사과");
        boolean result = Util.compare(p1, p2);
        System.out.println("result = [" + result + "]"); // result = [true]

        int result1 = Util.compare(10, 20);
        System.out.println("result1 = [" + result1 + "]"); // result1 = [-1]

    }
}
