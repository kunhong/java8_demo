package com.model.Shop;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class Company {
    private final int uniqueId;

    public Company() {
        this.uniqueId = 0;
    }

    public Company(int uniqueId) {
        this.uniqueId = uniqueId;
    }
}
