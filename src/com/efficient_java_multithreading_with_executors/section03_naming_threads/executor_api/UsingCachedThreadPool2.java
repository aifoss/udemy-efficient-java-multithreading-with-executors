package com.efficient_java_multithreading_with_executors.section03_naming_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskC;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class UsingCachedThreadPool2 {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        TimeUnit.SECONDS.sleep(15);

        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
