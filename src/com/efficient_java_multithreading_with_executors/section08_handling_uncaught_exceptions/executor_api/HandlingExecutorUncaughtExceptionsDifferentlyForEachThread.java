package com.efficient_java_multithreading_with_executors.section08_handling_uncaught_exceptions.executor_api;

import com.efficient_java_multithreading_with_executors.common.ExceptionLeakingTask;
import com.efficient_java_multithreading_with_executors.common.ThreadFactoryWithExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingExecutorUncaughtExceptionsDifferentlyForEachThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());

        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
