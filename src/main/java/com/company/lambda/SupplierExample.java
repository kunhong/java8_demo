package com.company.lambda;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };

        int num = intSupplier.getAsInt();
        System.out.println("intSupplier: " + num);

        Supplier<String> supplier = () -> {
            return "this is Supplier<String>";
        };

        String str = supplier.get();System.out.println("intSupplier: " + num);

    }
}
