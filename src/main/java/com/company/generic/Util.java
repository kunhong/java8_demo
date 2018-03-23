package com.company.generic;

public class Util {
    // 제네릭 메소드
    // public <타입파라미터, ...> 리턴타입 메소드명(매개변수, ...)
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }

    public static <K, V> boolean compare(Pair p1, Pair p2) {
        boolean keycompare = p1.getKey().equals(p2.getKey());
        boolean valuecompare = p1.getValue().equals(p2.getValue());

        return keycompare && valuecompare;
    }

    // 제한된 타입 파라미터 (bounded type parameter)
    // 상위 타입은 클래스뿐만 아니라 인터페이스도 가능하며 모두 extends를 사용한다.
    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return Double.compare(v1, v2);
    }
}
