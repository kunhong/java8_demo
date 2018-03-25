package com.company.thread;

import com.company.thread.StatePrintThread;
import com.company.thread.TargetThread;

public class ThreadStateExample {
    public static void main(String[] args) {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}