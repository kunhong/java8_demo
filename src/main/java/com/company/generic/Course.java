package com.company.generic;

// 제네릭타입<?> : Unboounded Wildcards(제한 없음)
// 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올수 있음

// <? extends 상위 타입>
// 타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다.

// <? super 하위 타입>
// 타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입만 올 수 있다.

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Course<T>{
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;

        // 타입 파리미터로 배열을 생성하려면 new T[n]형태로 배영을 생성할 수 없고 아래 형태로 생성해야 함
        students = (T[]) (new Object[capacity]);
    }

    public void add(T t) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }
}
