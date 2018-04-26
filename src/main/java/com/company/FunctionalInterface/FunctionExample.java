package com.company.FunctionalInterface;

import java.util.function.Function;

class Letter {
    public static String addHeader(String text) {
        return "HEAD : " + text;
    }

    public static String addFooter(String text) {
        return text + " --> Footer";
    }

    public static String checkSpelling(String text) {
        return text.replace("labda", "lambda");
    }
}

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        String str = transformationPipeline.apply("labda");
        System.out.println(str );
    }
}
