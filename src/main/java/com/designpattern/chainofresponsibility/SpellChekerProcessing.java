package com.designpattern.chainofresponsibility;

public class SpellChekerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return text.replace("labdas", "lambda");
    }
}
