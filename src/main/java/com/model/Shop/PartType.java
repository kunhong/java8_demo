package com.model.Shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PartType {
    MAIN_BOARD("main_board"),
    MEMORY("memory"),
    GRAPHIC_CARD("graphic_Card");

    private String name;
}
