package com.company.JavaEnum;

import java.util.List;

// 런타임에 Enum의 상수들이 변경될 일이 없기에 관리 대상인 Enum들은 미리 Bean에 등록하여 사용
public class EnumMapperUseClass {
    // 팩토리에 Enum 등록
    // @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("FeeType", FeeType.class);

        return enumMapper;
    }

    //@GetMapping("/categories")
    public List<EnumMapperValue> getCategories() {
        return enumMapper().get("FeeType");
    }
}
