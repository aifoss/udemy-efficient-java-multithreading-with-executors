package section07_terminating_threads.executor_api;

import common.FactorialTaskB;
import common.LoopTaskA;
import common.LoopTaskG;
import common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class TerminatingBlockedExecutorTasks {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        LoopTaskA task1 = new LoopTaskA();
        LoopTaskG task2 = new LoopTaskG();
        FactorialTaskB task3 = new FactorialTaskB(30, 500);

        Future<?> f1 = executorService.submit(task1);
        Future<?> f2 = executorService.submit(task2);
        Future<Long> f3 = executorService.submit(task3);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(300);

        System.out.println("[" + currentThreadName + "] Invoking cancel() on all tasks ...");

        f1.cancel(true);
        f2.cancel(true);
        f3.cancel(true);

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
