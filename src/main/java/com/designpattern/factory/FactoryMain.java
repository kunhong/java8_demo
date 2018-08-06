package com.designpattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMain {
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if(p != null) return p.get();
        throw new IllegalArgumentException("No such product" + name);
    }

    public static void main(String[] args) {
        Product product = createProduct("loan");
        product.printWhoAmI(); // My name is Loan

        
    }
}
