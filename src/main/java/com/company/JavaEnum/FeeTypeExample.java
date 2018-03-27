package com.company.JavaEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FeeTypeExample {

    //@GetMapping("no-bean-categories")
    public static List<EnumMapperValue> getNoBeanCategories() {
        return Arrays.stream(FeeType.values())
                .map(EnumMapperValue::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<EnumMapperValue> list = getNoBeanCategories();
        list.stream()
                .forEach(System.out::println);
        /*
          {code='PERCENT', title='정율'}
          {code='MONEY', title='정액'}
        */
    }
}
