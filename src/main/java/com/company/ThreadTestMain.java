package com.company;

import com.company.thread.Task;
import com.company.thread.ThreadA;
import com.company.thread.WorkerThread;


public class ThreadTestMain {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름 = [" + mainThread.getName() + "]");


        Runnable task = new Task();
        Thread thread1 = new Thread(task);
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 is running!");
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread3 is running!");
        });
        thread3.start();

        Thread workerThread = new WorkerThread();
        workerThread.start();

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread4 is running!");
            }
        };
        thread4.start();

        ThreadA threadA = new ThreadA();
        threadA.start();


    }

}
