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
public class SchedulingTasksForOneTimeExecutionUsingThreadAPI {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Timer timer = new Timer("Timer-Thread", true);
        Date currentTime = new Date();
        Date scheduledTime = TimerUtils.getFutureTime(currentTime, 5000);

        System.out.println("[" + currentThreadName + "] Current time: " + TimerUtils.dateFormatter.format(currentTime));

        ScheduledTaskA task1 = new ScheduledTaskA(8000);
        timer.schedule(task1, scheduledTime);

        System.out.println("[" + currentThreadName + "] Task-1 scheduled to run at specified time: "
                + TimerUtils.dateFormatter.format(scheduledTime));

        ScheduledTaskA task2 = new ScheduledTaskA(4000);
        long delayMillis = 10000;
        timer.schedule(task2, delayMillis);

        System.out.println("[" + currentThreadName + "] Task-2 scheduled to run in " + (delayMillis/1000)
                + " seconds of initial delay after current time, "
                + "i.e., at " + TimerUtils.dateFormatter.format(new Date(task2.scheduledExecutionTime())));


        ScheduledTaskA task3 = new ScheduledTaskA(0);
        delayMillis = 12000;
        timer.schedule(task3, delayMillis);

        System.out.println("[" + currentThreadName + "] Task-3 scheduled to run in " + (delayMillis / 1000)
                + " seconds of initial delay after current time, "
                + "i.e., at " + TimerUtils.dateFormatter.format(new Date(task3.scheduledExecutionTime())));

        scheduledTime = TimerUtils.getFutureTime(currentTime, 15000);
        ScheduledTaskA task4 = new ScheduledTaskA(0);
        timer.schedule(task4, scheduledTime);

        System.out.println("[" + currentThreadName + "] Task-4 scheduled to run at specified time: "
                + TimerUtils.dateFormatter.format(new Date(task4.scheduledExecutionTime())));

        task4.cancel();

        TimeUnit.MILLISECONDS.sleep(15000);

        System.out.println("[" + currentThreadName + "] Cancelling the timer now ...");

        timer.cancel();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
