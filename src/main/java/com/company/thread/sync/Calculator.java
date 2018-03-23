package com.company.thread.sync;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    // 자바는 임계 영역을 지정하기 위해 동기화(sychronized) 메소드와 동기화 블록을 제공한다.
    // synchronized 키워드는 인스턴스와 정적 메소드 어디든 붙일 수 있다.
    public /*synchronized*/ void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
