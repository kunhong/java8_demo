package com.effectiveJava.Ch7Method;

import java.math.BigInteger;
import java.util.*;

public class R41MethodOverloading {
    public static String classify(Set<?> s) { return "Set"; }
    public static String classify(List<?> s) { return "List"; }
    public static String classify(Collection<?> s) { return "Unknown"; }
    public static void main(String[] args) {
        Collection<?>[] collections= {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()};

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }

    }
}
