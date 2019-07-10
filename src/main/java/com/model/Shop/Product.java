package com.model.Shop;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@JsonDeserialize(as = Computer.class)
public abstract class Product {
    protected String name;
    protected int price;

    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    protected Product() {
        this.name = null;
        this.price = 0;
    }


}
