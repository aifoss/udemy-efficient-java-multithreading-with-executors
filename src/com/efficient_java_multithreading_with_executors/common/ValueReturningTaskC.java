package com.efficient_java_multithreading_with_executors.common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ValueReturningTaskC implements Runnable {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    public ValueReturningTaskC(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValueReturnTaskC-" + instanceNumber;

    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for " + sleepTime + " millis");

        try {
            TimeUnit.MICROSECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a + b;

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> DONE #####");

        synchronized (this) {
            System.out.println("[" + currentThreadName + "] <" + taskId + "> WAITING ...");
            this.notifyAll();
        }
    }

    public int getSum() {
        return sum;
    }

}
