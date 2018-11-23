package com.efficient_java_multithreading_with_executors.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class FactorialTaskA implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private volatile boolean shutdown = false;

    private long a;
    private long factorial;
    private long sleepTime;

    public FactorialTaskA(long a, long sleepTime) {
        this.a = a;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskA" + instanceNumber;
    }

    @Override
    public Long call() throws Exception {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");

        factorial = 1L;


        for (long i = 1; i <= a; i++) {
            factorial *= i;

            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Iteration-" + i + ", Intermediate Result = " + factorial);

            TimeUnit.MILLISECONDS.sleep(sleepTime);

            synchronized (this) {
                if (shutdown) {
                    factorial = -1L;
                    break;
                }
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");

        return factorial;
    }

    public void cancel() {
        System.out.println("***** [" + Thread.currentThread().getName() + "] <" + taskId + "> Shutting down *****");

        synchronized (this) {
            this.shutdown = true;
        }
    }

}
