package com.designpattern.doubledispatch;

public class Report {
    public void printReport(Teacher teacher) {
        System.out.println("printReport(Teacher teacher) ");

    }

    public void printReport(Principal principal) {
        System.out.println("printReport(Principal teacher) ");
    }
}
