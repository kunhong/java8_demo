package com.company.optional;


import lombok.Getter;

import java.util.Optional;

@Getter
public class Car {
    private Optional<Insurance> insurance = null;
}
