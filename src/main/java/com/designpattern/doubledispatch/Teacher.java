package com.designpattern.doubledispatch;

public class Teacher implements Staff {
    @Override
    public void viewReport(Report report) {
        report.printReport(this);
    }
}
