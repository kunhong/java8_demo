package com.company.thread;

public class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println("WorkerThread is running!");
    }
}
