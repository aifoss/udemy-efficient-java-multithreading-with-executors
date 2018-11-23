package com.efficient_java_multithreading_with_executors.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CalculationTaskA implements Callable<Integer> {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;

    public CalculationTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskA-" + instanceNumber;
    }

    @Override
    public Integer call() throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for " + sleepTime + " millis");

        TimeUnit.MICROSECONDS.sleep(sleepTime);

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> DONE #####");

        return a + b;
    }

}
