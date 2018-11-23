package com.efficient_java_multithreading_with_executors.common;

import com.efficient_java_multithreading_with_executors.util.TimerUtils;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CalculationTaskD implements Callable<Integer> {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;

    public CalculationTaskD(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValueReturnTaskD-" + instanceNumber;
    }

    @Override
    public Integer call() throws Exception {
        Date startTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING AT " + TimerUtils.dateFormatter.format(startTime));
        System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for " + sleepTime + " millis");

        TimeUnit.MICROSECONDS.sleep(sleepTime);

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> FINISHED AT " + TimerUtils.dateFormatter.format(new Date()));

        return a + b;
    }

}
