package com.company.thread;

public class Task  implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread1 is running!");
    }
}
