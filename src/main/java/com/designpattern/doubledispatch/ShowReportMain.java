package com.designpattern.doubledispatch;

public class ShowReportMain {
    public static void main(String[] args) {
        Report report = new Report();
        Staff staff = new Principal();
        staff.viewReport(report); // printReport(Principal teacher)
        staff = new Teacher();
        staff.viewReport(report); // printReport(Teacher teacher) 
    }
}
