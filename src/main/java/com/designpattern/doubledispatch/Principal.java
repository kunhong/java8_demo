package com.designpattern.doubledispatch;

public class Principal<T extends Report> implements Staff<T> {
    @Override
    public void viewReport(T report) {
        report.printReport(this);
    }
}
