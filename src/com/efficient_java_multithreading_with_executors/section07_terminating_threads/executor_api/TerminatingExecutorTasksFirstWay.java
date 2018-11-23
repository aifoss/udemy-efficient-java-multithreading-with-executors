package com.efficient_java_multithreading_with_executors.section07_terminating_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.FactorialTaskA;
import com.efficient_java_multithreading_with_executors.common.LoopTaskE;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class TerminatingExecutorTasksFirstWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        LoopTaskE task1 = new LoopTaskE();
        FactorialTaskA task2 = new FactorialTaskA(30, 1000);

        executorService.execute(task1);
        executorService.submit(task2);

        executorService.shutdown();

        TimeUnit.MILLISECONDS.sleep(3);

        task1.cancel();
        task2.cancel();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
