package com.company.JavaEnum;


public class LegacyCalculator {
    public static void main(String[] args) {
        CalculatorType codeA = CalculatorType.CAL_A;
        CalculatorType codeB = CalculatorType.CAL_B;
        CalculatorType codeC = CalculatorType.CAL_C;
        CalculatorType codeETC = CalculatorType.CAL_ETC;

        System.out.println("codeA : " + codeA.calculate(10));
        System.out.println("codeB : " + codeB.calculate(10));
        System.out.println("codeC : " + codeC.calculate(10));
        System.out.println("codeETC : " + codeETC.calculate(10));
    }
}
