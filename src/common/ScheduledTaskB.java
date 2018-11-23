package common;

import util.TimerUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ScheduledTaskB implements Runnable {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private long sleepTime;

    public ScheduledTaskB(long sleepTime) {
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ScheduledTaskB-" + instanceNumber;
    }

    @Override
    public void run() {
        Date startTime = new Date();

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTED AT: "
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
