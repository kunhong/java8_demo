package com.company.lambda;


public class UsingLocalVariable {

    // 람다식에서 메소드의 매개 변수 또는 로컬 변수를 사용하면 이 두 변수는 final 특성을 가져야 한다.
    // 매개 변수 또는 로컬 변수를 람다식에서 읽는 것은 허용되지만, 람다식 내부 또는 외부에서 변경할 수 없다.

    // 익명 객체 내부에서 메소드의 매개 변수나 로컬 변수를 사용할 경우, 이 변수들은 final 특성을 가져야 한다.
    // 자바 7 이전까지는 반드시 final 키워드로 이 변수를 선언해야 했지만, 자바 8 이후부터는 final 없이 선언해도 좋다.


    public void method(int arg) { // arg는 final 특성을 가짐
        int localVar = 40; // localVar는 final 특성을 가짐

        // final 특성 때문에 수정 불가
        //arg = 31;
        //localVar = 41;

        MyFunctionalInterface fi = () -> {
            System.out.println("arg = [" + arg + "]");
            System.out.println("localVar = [" + localVar + "]");
        };

        fi.method();
    }
}
