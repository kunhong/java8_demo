package com.company.thread;

import com.company.thread.sync.Calculator;
import com.company.thread.sync.User1;
import com.company.thread.sync.User2;

public class SyncThreadTestMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }
}
