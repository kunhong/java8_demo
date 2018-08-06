package com.designpattern.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellChekerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't handle labdas really sexy?");
        System.out.println(result); // From Raoul, Mario and Alan : Aren't handle lambda really sexy?


        // 람바 표현식으로 변경
        UnaryOperator<String> headerTextProcessing = (String text) -> "From Raoul, Mario and Alan : " + text;
        UnaryOperator<String> spellCheckProcessing = (String text) -> text.replace("labdas", "lambda");
        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckProcessing);
        result = pipeline.apply("Aren't handle labdas really sexy?");
        System.out.println(result); // From Raoul, Mario and Alan : Aren't handle lambda really sexy?

    }
}
