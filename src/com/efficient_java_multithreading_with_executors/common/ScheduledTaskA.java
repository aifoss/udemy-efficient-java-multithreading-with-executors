package com.efficient_java_multithreading_with_executors.common;

import com.efficient_java_multithreading_with_executors.util.TimerUtils;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ScheduledTaskA extends TimerTask {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private long sleepTime;

    public ScheduledTaskA(long sleepTime) {
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ScheduledTaskA-" + instanceNumber;
    }

    @Override
    public void run() {
        Date startTime = new Date();
        Date scheduledForRunningTime = new Date(super.scheduledExecutionTime());


        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> SCHEDULED TO RUN AT: "
                + TimerUtils.dateFormatter.format(scheduledForRunningTime) + ", ACTUALLY STARTED AT: "
                + TimerUtils.dateFormatter.format(startTime) + " #####");

        try {
            TimeUnit.MICROSECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> FINISHED AT: "
                + TimerUtils.dateFormatter.format(new Date()) + " #####");
    }

}
