package com.model.Shop;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
public class Computer extends Product {
    private Map<String, Company> companyMap = new HashMap<>();
    private List<Part> parts = new ArrayList<>();

    public Computer() {
        super(null, 0);
    }

    public Computer(String name, int price) {
        super(name, price);
    }

    public void addPart(Part product) {
        parts.add(product);
    }

    public void addCompany(String name, int id) {
        companyMap.put(name, new Company(id));
    }

    public void clear() {
        parts.clear();
        companyMap.clear();
    }
}
