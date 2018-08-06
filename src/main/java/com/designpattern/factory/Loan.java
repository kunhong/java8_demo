package com.designpattern.factory;

public class Loan implements Product {
    @Override
    public void printWhoAmI() {
        System.out.println("My name is Loan");
    }
}
