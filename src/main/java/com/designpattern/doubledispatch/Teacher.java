package com.designpattern.doubledispatch;

public class Teacher<T extends Report> implements Staff<T> {
    @Override
    public void viewReport(T report) {
        report.printReport(this);
    }
}
