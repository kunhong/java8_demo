package com.company.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Member {
    private String name;
    private String id;

    public Member(String name) {
        this.name = name;
    }
}
