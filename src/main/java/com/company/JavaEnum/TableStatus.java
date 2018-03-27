package com.company.JavaEnum;

import lombok.Getter;

public enum TableStatus {

    Y("1", true),
    N("0", false);

    @Getter private String tableValue;
    @Getter private boolean table2Value;

    TableStatus(String tableValue, boolean table2Value) {
        this.tableValue = tableValue;
        this.table2Value = table2Value;
    }

}
