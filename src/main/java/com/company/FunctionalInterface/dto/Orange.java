package com.company.FunctionalInterface.dto;

import lombok.Data;

@Data
public class Orange extends Fruit{
    Orange(int weight) {
        super(weight);
    }
}
