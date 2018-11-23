package com.efficient_java_multithreading_with_executors.section07_terminating_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.CalculationTaskC;
import com.efficient_java_multithreading_with_executors.common.LoopTaskF;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

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
public class TerminatingExecutorTasksSecondWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        CalculationTaskC task1 = new CalculationTaskC();
        LoopTaskF task2 = new LoopTaskF();
        LoopTaskF task3 = new LoopTaskF();

        Future<Long> f1 = executorService.submit(task1);
        Future<?> f2 = executorService.submit(task2);
        Future<?> f3 = executorService.submit(task3);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(300);

        System.out.println("[" + currentThreadName + "] Interrupting 'CalculationTaskC1' ...");
        System.out.println("[" + currentThreadName + "] Cancelling f1 = " + f1.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting 'LoopTaskF1' ...");
        System.out.println("[" + currentThreadName + "] Cancelling f2 = " + f2.cancel(true));

        System.out.println("[" + currentThreadName + "] Interrupting 'LoopTaskF2' ...");
        System.out.println("[" + currentThreadName + "] Cancelling f3 = " + f3.cancel(true));


        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
