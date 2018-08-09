package com.company.optional;

import lombok.Data;
import lombok.Getter;

import java.util.Optional;

public class Person {
    @Getter private Optional<Car> car = null;
    @Getter private int age;
}
