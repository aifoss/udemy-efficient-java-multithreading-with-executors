package com.efficient_java_multithreading_with_executors.common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskB implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskB() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskB" + instanceNumber;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Amazing-Thread-" + instanceNumber);

        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 10; i > 0; i--) {
            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
    }

}
