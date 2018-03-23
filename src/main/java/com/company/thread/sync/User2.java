package com.company.thread.sync;

public class User2 extends Thread {
    private  Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("CalculatorUser2");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}
