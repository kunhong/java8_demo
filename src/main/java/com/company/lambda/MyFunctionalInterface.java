package com.company.lambda;

// 람다식은 하나의 메소드를 정의하기 때문에 두 개 이상의 추상 메소드가 선언된 인터페이스는 람다식을 이용해서 구현 객체를 생성할 수 없다.
@FunctionalInterface
public interface MyFunctionalInterface {
    public void method();
    //public void otherMethod(); // 오류
}
