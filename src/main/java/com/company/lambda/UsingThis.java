package com.company.lambda;

public class UsingThis {
    public int outterField = 10;

    public class Inner {
        int innerField = 20;

        // 람바에서의 this는 내부적으로 생성되는 익명 객체의 참조가 아니라 람다식을 실행하는 객체의 참조이다.
        public void method() {
            MyFunctionalInterface fi = () -> {
                System.out.println("outterField: " + outterField);
                // 바깥 객체의 참조를 얻기 위해서는 클래스명.this를 사용
                System.out.println("outterField: " + UsingThis.this.outterField);

                System.out.println("innerField: " + innerField);
                // 람다식 내부에서는 this는 Inner객체를 참조
                System.out.println("innerField: " + this.innerField);

            };
            fi.method();

        }
    }
}
