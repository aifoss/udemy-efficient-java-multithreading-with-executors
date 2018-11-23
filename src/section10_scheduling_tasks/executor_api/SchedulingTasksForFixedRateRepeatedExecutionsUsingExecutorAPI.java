package section10_scheduling_tasks.executor_api;

import common.NamedThreadFactory;
import common.ScheduledTaskB;
import util.TimerUtils;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class SchedulingTasksForFixedRateRepeatedExecutionsUsingExecutorAPI {

    public static void main(String[] args) throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2, new NamedThreadFactory());

        System.out.println("[" + currentThreadName + "] Current time: " + TimerUtils.dateFormatter.format(new Date()));

        ScheduledFuture<?> f1 = scheduledExecutorService.scheduleAtFixedRate(new ScheduledTaskB(1000), 4, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> f2 = scheduledExecutorService.scheduleAtFixedRate(new ScheduledTaskB(5000), 4, 2, TimeUnit.SECONDS);

//        for (int i = 0; i < 10; i++) {
//            Date scheduledTime = TimerUtils.getFutureTime(new Date(), f1.getDelay(TimeUnit.MILLISECONDS));
//            System.out.println("[" + currentThreadName + "] Next run of Task-1 scheduled at " + TimerUtils.dateFormatter.format(scheduledTime));
//
//            TimeUnit.MILLISECONDS.sleep(3000);
//        }

//        f2.cancel(true);

        TimeUnit.MILLISECONDS.sleep(15000);

        scheduledExecutorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
