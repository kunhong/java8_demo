package com.designpattern.doubledispatch;

public class Principal implements Staff {
    @Override
    public void viewReport(Report report) {
        report.printReport(this);
    }
}
