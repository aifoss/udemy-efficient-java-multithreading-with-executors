package section10_scheduling_tasks.executor_api;

import common.CalculationTaskD;
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
public class SchedulingTasksForOneTimeExecutionUsingExecutorAPI {

    public static void main(String[] args) throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3, new NamedThreadFactory());

        System.out.println("[" + currentThreadName + "] Current time: " + TimerUtils.dateFormatter.format(new Date()));

        ScheduledFuture<?> f1 = scheduledExecutorService.schedule(new ScheduledTaskB(3000), 4, TimeUnit.SECONDS);
        ScheduledFuture<Integer> f2 = scheduledExecutorService.schedule(new CalculationTaskD(2, 3, 3000), 6, TimeUnit.SECONDS);
        ScheduledFuture<?> f3 = scheduledExecutorService.schedule(new ScheduledTaskB(0), 8, TimeUnit.SECONDS);
        ScheduledFuture<Integer> f4 = scheduledExecutorService.schedule(new CalculationTaskD(3, 4, 0), 10, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

        f1.cancel(true);
        f2.cancel(true);

        System.out.println("[" + currentThreadName + "] Retrieving results ...");

//        System.out.println("[" + currentThreadName + "] Task-1 result = " + f1.get());
//        System.out.println("[" + currentThreadName + "] Task-2 result = " + f2.get());
        System.out.println("[" + currentThreadName + "] Task-3 result = " + f3.get());
        System.out.println("[" + currentThreadName + "] Task-4 result = " + f4.get());

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
