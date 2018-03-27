package com.company.JavaEnum;

import lombok.Getter;

public class EnumMapperValue {
    @Getter private String code;
    @Getter private String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
