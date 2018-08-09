package com.company.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalDemo {
    public static String getCarInsuranceName(Optional<Person> person) {

        // map(Person::getCar) 는 Optional<Car> 반환 결국 Optional<Optional<Car>> 이런식으로 되기 때문에 컴파일 에러 발생
//        Optional<String> name = optPerson.map(Person::getCar)
//                .map(Car::getInsurance)
//                .map(Insurance::getName);

        // 위의 중첩되는 구조는 flatMap 메소드를 이용하면 된다.
        // flatMap은 함수를 인수로 받아서 다른 스트림으로 반환하는 메서드
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName) // Optional<Insurance>를 Optional<String> 으로 반환
                .orElse("Unknown");

    }

    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName) // Optional<Insurance>를 Optional<String> 으로 반환
                .orElse("Unknown");

    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        }
        else {
            return Optional.empty();
        }
    }

    // 개선 버전
    // 첫 번째 Optional에 flaMap을 호출했으므로 첫 번째 Optional이 비어 있다면 인수로 전달한 람다 표현식이 실행되지 않고 그대로 빈 Optional을 반환한다.
    // 반면 person값이 있으면 flatMap메서드에 필요한 Optional<Insurance>를 반환하는 Function의 입력으로 person을 사용한다.

    // 두 번째 Optional에서 map을 호출하므로 Optional이 car값을 포함하지 않으면 빈 Optional을 반환한다.
    // 마지막으로 person과  car 모두 존재하면 map 메서드로 전달한 람다표현식이 findCheapestInsurance을 안전하게 호출한다.

    public static Optional<Insurance> nullSafeFindCheapestInsurance2(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public static Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }

    // 정수로 변환할 수 없는 문자열 문제를 빈 Optional 로 해결하는 방법
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        // null이 아닌 값으로 Optional 만들기
        Car car = null;
        // Optional<Car> optCar = Optional.of(car); // 즉시 에러 발생 (NullPointException)

        // null값으로 Optional 만들기
        // 즉 null 값을 저장할 수 있는 Optional을 만듬
        Insurance insurance = null;
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);
        System.out.println(name); // Optional.empty

        Person person = null;
        // getCarInsuranceName(person); // java.lang.NullPointerException
        person = new Person();

        System.out.println(getCarInsuranceName(Optional.of(person)));

        // get() 메소드
        // 값을 읽는 가장 간단한 메서드면서 동시에 가장 안전하지 않은 메서드.
        // 래핑된 값이 있으면 해당 값을 반환 없으면 NullPointerException 발생

        // orElseGet (Supplier<? extends T> other)
        // Optional에 값이 없을 때만 Supplier가 실행

        // ifPresent (Consumer<? super T>> consumer)
        // 값이 존재할 때 인수로 넘겨준 동작을 실행
        // 없으면 아무 일도 일어나지 않음

        ////////////////////////////////////////////////////////////////////////
        // filter

        optionalInsurance.filter(insurance1 -> "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("OK"));


    }
}
