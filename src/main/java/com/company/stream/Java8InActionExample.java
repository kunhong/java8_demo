package com.company.stream;

import com.company.data.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class Java8InActionExample {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizze", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)

    );

    public static void main(String[] args) {

        // counting : 메뉴에서 요리수를 계산
        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes2 = menu.stream().count();
        System.out.println("howManyDishes = [" + howManyDishes + "]"); // 9
        System.out.println("howManyDishes2 = [" + howManyDishes2 + "]"); // 9

        // maxBy, minBy : 스트림값에서 최대값과 최솟값 검색
        // 위 2 함수는 스트림의 요소를 비교하는데 사용할 Comparator를 인수롤 받는다.
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println("mostCalorieDish = " + mostCalorieDish); // mostCalorieDish = Optional[pork]

        // 요약 연산 : 객체의 숫자 필드의 합계나 평균 등을 반환하는 연산
        // Collectors.summingInt : 객체를 int로 매핑하는 함수를 인수로 받음
        // 인수로 전달된 함수는 객체를 int로 매핑한 컬렉터를 반환한다.
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories); // 4200

        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("avgCalories = " + avgCalories); // 466.6666666666667

        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics = " + menuStatistics); // IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}

        // 문자열 연결 : joining
        // 스트림의 각 객체에 toString 메서드를 호출해서 추출한 모든 문자열을 하나의 문자열로 연결해서 반환
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
        //String shortMenu = menu.stream().collect(Collectors.joining()); // toString이 포함된 경우
        String shortMenu2 = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));

        System.out.println("shortMenu = " + shortMenu); // shortMenu = porkbeefchickenfrench friesriceseason fruitpizzeprawnssalmon
        System.out.println("shortMenu2 = " + shortMenu2); //shortMenu2 = pork, beef, chicken, french fries, rice, season fruit, pizze, prawns, salmon
        
    }
}
