package com.company.generic;

import lombok.Data;

@Data
public class Product <T, M> {
    private T kind;
    private M model;
}
