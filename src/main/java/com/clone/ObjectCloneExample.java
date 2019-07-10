package com.clone;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.model.Shop.Computer;
import com.model.Shop.Part;
import com.model.Shop.PartType;
import com.model.Shop.Product;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectCloneExample {
    public static void main(String[] args) {
        Computer product = new Computer("macbook", 980000);
        product.addPart(
                Part.builder()
                        .partType(PartType.MAIN_BOARD)
                        .name("main board")
                        .price(34000)
                        .build()
        );

        product.addPart(
                Part.builder()
                        .partType(PartType.MEMORY)
                        .name("memory")
                        .price(24000)
                        .build()
        );

        product.addPart(
                Part.builder()
                        .partType(PartType.GRAPHIC_CARD)
                        .name("graphic card")
                        .price(89000)
                        .build()
        );

        product.addCompany("lg", 342530);
        product.addCompany("ea", 453423);

        Computer product_copy = ObjectMapperJsonSerializer.INSTANCE.clone(product);


        product.clear();

        product.addPart(
                Part.builder()
                        .partType(PartType.MAIN_BOARD)
                        .name("xxxxxxx")
                        .price(0)
                        .build()
        );

        product.addPart(
                Part.builder()
                        .partType(PartType.MEMORY)
                        .name("yyyyyy")
                        .price(1)
                        .build()
        );

        product.addPart(
                Part.builder()
                        .partType(PartType.GRAPHIC_CARD)
                        .name("zzzzzz")
                        .price(2)
                        .build()
        );

        product.addCompany("kk", 66);
        product.addCompany("uu", 77);
        System.out.println(ToStringBuilder.reflectionToString(product_copy, ToStringStyle.DEFAULT_STYLE));
        System.out.println(ToStringBuilder.reflectionToString(product, ToStringStyle.DEFAULT_STYLE));

        List<Part> origin_parts = product.getParts();
        List<Part> copy_parts = ObjectMapperJsonSerializer.INSTANCE.clone(origin_parts);

        System.out.println(ToStringBuilder.reflectionToString(origin_parts, ToStringStyle.DEFAULT_STYLE));
        System.out.println(ToStringBuilder.reflectionToString(copy_parts, ToStringStyle.DEFAULT_STYLE));

        origin_parts.stream()
                .forEach(part -> part.setName("aaaaaaaa"));

        origin_parts.stream().forEach(System.out::println);
        System.out.println(">>>>>>>> " + copy_parts);
        System.out.println(">>>>>>>> " + copy_parts.get(0));
        System.out.println(">>>>>>>> " + copy_parts.get(1));
        System.out.println(">>>>>>>> " + copy_parts.get(2).getName());



    }
}
