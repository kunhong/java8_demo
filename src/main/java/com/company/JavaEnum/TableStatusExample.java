package com.company.JavaEnum;

public class TableStatusExample {
    public static void main(String[] args) {
        TableStatus status1 = TableStatus.Y;
        TableStatus status2 = TableStatus.N;

        System.out.println("status1 = [" + status1.getTableValue() + "]");
        System.out.println("status1 = [" + status1.isTable2Value() + "]");
        System.out.println("status2 = [" + status2.getTableValue() + "]");
        System.out.println("status2 = [" + status2.isTable2Value() + "]");
    }
}
