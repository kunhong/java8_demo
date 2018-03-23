package com.company.generic;

import lombok.Data;

@Data
public class ChildProduct<T, M, C> extends Product<T, M> {
    private C company;
}
