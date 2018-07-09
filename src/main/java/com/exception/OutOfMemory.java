package com.exception;

// Reference
// http://byplacebo.tistory.com/m/21

// 메모리 덤프 생성 방법
// 1. JMap : 즉시 덤프 생성
// 2. JVM 옵션을 통한 OOME 시 자동으로 덤프 생성
// -XX:-HeapDumpOnOutOfMemoryError
// -XX:HeapDumpPath=./java_pid<pid>.hprof

// -XX:+PrintClassHistogramAfterFullGC, -XX:+PrintClassHistogramBeforeFullGC
// http://www.oracle.com/technetwork/java/javase/clopts-139448.html#gbzrr
public class OutOfMemory {
    static final int SIZE=2*1024*1024;

    public static void main(String[] args) {
        int[] i = new int[SIZE];
    }
}
