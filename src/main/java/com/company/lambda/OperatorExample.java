package com.company.lambda;

import java.util.function.IntBinaryOperator;

// Operator 함수 인터페이스는 Function과 동일하게 매개 변수와 리턴값이 있는 applyXXX() 메소드를 가지고 있다.
// 하지만 이 메소드들은 매개값을 리턴값으로 매핑하는 역할보다는 매개값을 이용해서 연산을 수행한 후 동일한 리턴값을 제공하는 역할을 한다.
public class OperatorExample {
    private static int[] scores = {92, 95, 87};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        int max = maxOrMin((a, b) -> {
            if (a >= b) return a;
            else return b;
        });
        System.out.println("max = [" + max + "]");

        int min = maxOrMin((a, b) -> {
            if (a <= b) return a;
            else return b;
        });
        System.out.println("min = [" + min + "]");
    }
}
