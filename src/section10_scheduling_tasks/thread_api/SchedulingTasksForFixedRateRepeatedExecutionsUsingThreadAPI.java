package section10_scheduling_tasks.thread_api;

import common.ScheduledTaskA;
import util.TimerUtils;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class SchedulingTasksForFixedRateRepeatedExecutionsUsingThreadAPI {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Timer timer = new Timer("Timer-Thread", true);
        Date currentTime = new Date();

        System.out.println("[" + currentThreadName + "] Current time: " + TimerUtils.dateFormatter.format(currentTime));

        Date scheduledTime = TimerUtils.getFutureTime(currentTime, 3000);
        long intervalMillis = 2000;

        ScheduledTaskA task1 = new ScheduledTaskA(1000);
        timer.scheduleAtFixedRate(task1, scheduledTime, intervalMillis);

        System.out.println("[" + currentThreadName + "] Task-1 first-run scheduled at: "
                + TimerUtils.dateFormatter.format(scheduledTime)
                + " and repeatedly at an interval of every " + (intervalMillis / 1000) + " seconds");

        long delayMillis = 4000;

        ScheduledTaskA task2 = new ScheduledTaskA(1000);
        timer.scheduleAtFixedRate(task2, delayMillis, intervalMillis);

        System.out.println("[" + currentThreadName + "] Task-2 first-run scheduled after "
                + (delayMillis/1000) + " seconds"
                + " and repeatedly at an interval of every " + (intervalMillis / 1000) + " seconds");

        TimeUnit.MILLISECONDS.sleep(15000);

        System.out.println("[" + currentThreadName + "] Cancelling the timer now ...");

        timer.cancel();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
