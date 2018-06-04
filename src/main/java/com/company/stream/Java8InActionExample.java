package com.company.stream;

import com.company.data.Dish;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.val;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class Java8InActionExample {
    public enum CaloricLevel {DIET, NORMAL, FAT}
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

    // 제네릭 와일드 카드 '?' 사용법
    // 컬렉터의 누적자 형식이 알려지지 않았음을, 즉 누적자의 형식이 자유로움을 의미
    public static <T> Collector<T, ?, Long> counting() {
        return Collectors.reducing(0L, e -> 1L, Long::sum);
    }

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

        String shortMenu3 = menu.stream().map(Dish::getName).collect(Collectors.reducing((s1, s2) -> s1 + s2)).get();
        System.out.println("shortMenu3 = " + shortMenu3); // shortMenu3 = porkbeefchickenfrench friesriceseason fruitpizzeprawnssalmon

        String shortMenu4 = menu.stream().collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        System.out.println("shortMenu4 = " + shortMenu4); // shortMenu4 = porkbeefchickenfrench friesriceseason fruitpizzeprawnssalmon

        // 범용 리듀싱 요약 연산
        // Collectors.reducing
        int totalCalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories2 : " + totalCalories2); // totalCalories2 : 4200

        int totalCalories3 = menu.stream().collect(Collectors.reducing(0, // 초기값
                Dish::getCalories, // 변환함수
                Integer::sum)); // 합계 함수
        System.out.println("totalCalories3 : " + totalCalories3); // totalCalories3 : 4200

        int totalCalories4 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("totalCalories4 : " + totalCalories4); // totalCalories4 : 4200

        // IntStream덕분에 자동 언박싱 연산을 수행하거나 Integer를 int로 변환하는 과정을 피할 수 있으므로 성능까지 좋다.
        int totalCalories5 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("totalCalories5 : " + totalCalories5); // totalCalories5 : 4200

        Optional<Dish> mostCaloriesDish = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("mostCaloriesDish : " + mostCaloriesDish); // mostCaloriesDish : Optional[pork]

        // collect : 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 메서드
        // reduce : 두 값을 하나로 도출하는 불변형 연산

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 그룹화
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println("dishesByType : " + dishesByType); // dishesByType : {MEAT=[pork, beef, chicken], FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizze]}

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println("dishesByCaloricLevel : " + dishesByCaloricLevel);
        // dishesByCaloricLevel :
        // {FAT=[pork], DIET=[chicken, rice, season fruit, prawns],
        // NORMAL=[beef, french fries, pizze, salmon]}

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 다수준 그룹화
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Map<Dish.Type, Map<CaloricLevel, List<Dish>>>
        val dishesByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                            })));

        System.out.println("dishesByTypeCaloricLevel : " + dishesByTypeCaloricLevel);

        //dishesByTypeCaloricLevel :
        // {MEAT={FAT=[pork], DIET=[chicken], NORMAL=[beef]},
        // FISH={DIET=[prawns], NORMAL=[salmon]},
        // OTHER={DIET=[rice, season fruit], NORMAL=[french fries, pizze]}}


        //////////////////////////////////////////////////////////////////////////////////////////
        // 서브그룹으로 데이터 수집
        //////////////////////////////////////////////////////////////////////////////////////////
        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(
                Dish::getType, counting()
        ));

        System.out.println("typesCount : " + typesCount);
        // typesCount : {MEAT=3, FISH=2, OTHER=4}

        // 요리의 종류를 분류하는 컬렉터로 메뉴에서 가장 높은 칼로리를 가진 요리를 찾는 프로그램
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("mostCaloricByType : " + mostCaloricByType);
        // mostCaloricByType : {MEAT=Optional[pork], FISH=Optional[salmon], OTHER=Optional[pizze]}

        // Note : groupBy 컬렉터는 스트림의 첫 번째 요소를 찾은 이후에야 그룹화 맵에 새로운 키를 추가한다.
        // 결국 굳이 Optional 래퍼를 사용할 필요가 없다.


        //////////////////////////////////////////////////////////////////////////////////////////
        // 컬렉터 결과를 다른 형식에 적용하기
        //////////////////////////////////////////////////////////////////////////////////////////
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType, // 분류 함수
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)), // 감싸인 컬렉터
                                Optional::get // 변환 함수
                        )));
        // collectingAndThen : 적용할 컬렉터와 변환함수를 인수로 받아 다른 컬렉터로 반환
        // 반환하는 컬렉터는 기존 컬렉터의 래퍼 역할을 하며 collect의 마지막 과정에서 변환함수로 자신이 반환하는 값을 매핑한다.
        // 중요 : 리튜싱 컬렉터는 절대 Optional.empty()를 반환하지 않는다.
        System.out.println("mostCaloricByType2 : " + mostCaloricByType2);
        // mostCaloricByType2 : {MEAT=pork, FISH=salmon, OTHER=pizze}

        //////////////////////////////////////////////////////////////////////////////////////////
        // groupingBy 다른 컬렉터 예제
        //////////////////////////////////////////////////////////////////////////////////////////
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println("totalCaloriesByType : " + totalCaloriesByType);
        // totalCaloriesByType : {MEAT=1900, FISH=750, OTHER=1550}

        // mapping : 스트림의 인수를 변환하는 함수와 변환 함수의 결과 객체를 누적하는 컬렉터를 인수로 받는다.
        // 입력 요소를 누적하기 전에 매핑 함수를 적용해서 다양한 형식의 객체를 주어진 형식의 컬렉터에 맞게 변환하는 역할을 한다.
        // 각 요리 형식에 존재하는 모든 CaloricLevel값을 알고자 할때
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping( dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            }
                            else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            }
                            else {
                                return CaloricLevel.FAT;
                            }

                        },
                                toSet()))
                );
        System.out.println("caloricLevelByType : " + caloricLevelByType);
        // caloricLevelByType : {MEAT=[FAT, DIET, NORMAL], FISH=[DIET, NORMAL], OTHER=[DIET, NORMAL]}

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType2 = menu.stream()
                .collect(
                        groupingBy(Dish::getType, mapping( dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    }
                                    else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    }
                                    else {
                                        return CaloricLevel.FAT;
                                    }

                                },
                                toCollection(HashSet::new)))
                );
        System.out.println("caloricLevelByType2 : " + caloricLevelByType2);
        // caloricLevelByType2 : {MEAT=[FAT, DIET, NORMAL], FISH=[DIET, NORMAL], OTHER=[DIET, NORMAL]}


        //////////////////////////////////////////////////////////////////////////////////////////
        // 분할 : partitioningBy
        //////////////////////////////////////////////////////////////////////////////////////////
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println("partitionedMenu : " + partitionedMenu);
        // partitionedMenu :
        // {false=[pork, beef, chicken, prawns, salmon],
        // true=[french fries, rice, season fruit, pizze]}
        List<Dish> vegetarianDishes = partitionedMenu.get(true);

        List<Dish> vegetarianDishes2 = menu.stream()
                .filter(Dish::isVegetarian).collect(toList());


        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));
        System.out.println("vegetarianDishesByType : " + vegetarianDishesByType);
        // vegetarianDishesByType :
        // {false={MEAT=[pork, beef, chicken], FISH=[prawns, salmon]},
        // true={OTHER=[french fries, rice, season fruit, pizze]}}

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println("mostCaloricPartitionedByVegetarian : " + mostCaloricPartitionedByVegetarian);
        // mostCaloricPartitionedByVegetarian : {false=pork, true=pizze}










    }
}
