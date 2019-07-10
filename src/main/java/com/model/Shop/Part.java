package com.model.Shop;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Part  {
    private PartType partType;
    private String name;
    private int price;
}

