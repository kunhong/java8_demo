package com.company.lambda;

// 메소드 참조는 메소드를 참조해서 매개 변수의 정보 및 리턴 타입을 알아내어, 람다식에서 불필요한 매개 변수를 제거하는 것이 목

import java.util.function.IntBinaryOperator;

// 정적 및 인스턴스 메소드 참조
public class MethodReferencesExample {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println(operator.applyAsInt(10,20)); // 30

        operator = Calculator::staticMethod;
        System.out.println(operator.applyAsInt(100,200)); // 300

        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println(operator.applyAsInt(10,20)); // 30

        operator = obj ::instanceMethod;
        System.out.println(operator.applyAsInt(10,20)); // 30


    }

}
