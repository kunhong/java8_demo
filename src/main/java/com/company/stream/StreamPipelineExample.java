package com.company.stream;

import com.company.data.Member;

import java.util.Arrays;
import java.util.List;

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("홍길동", Member.MALE, 30),
                new Member("김나리", Member.FEMAIL, 20),
                new Member("원빈", Member.MALE, 45),
                new Member("이나영", Member.FEMAIL, 27)
                );

        double ageAvg = list.stream()
                .filter(m -> m.getSex() == Member.MALE)
                // mapXXX() 메소드
                /*
                *        A -> C
                * B A ->        ---> D C
                *        B -> D
                * */
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();


        System.out.println("ageAvg = [" + ageAvg  + "]");

    }
}
