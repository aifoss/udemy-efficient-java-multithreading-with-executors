package com.efficient_java_multithreading_with_executors.section08_handling_uncaught_exceptions.executor_api;

import com.efficient_java_multithreading_with_executors.common.ExceptionLeakingTask;
import com.efficient_java_multithreading_with_executors.common.ThreadExceptionHandler;
import com.efficient_java_multithreading_with_executors.common.ThreadFactoryWithExceptionHandlerAlternator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingExecutorUncaughtExceptionsDefaultsAndOverrides {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlerAlternator());

        ExceptionLeakingTask task1 = new ExceptionLeakingTask();
        ExceptionLeakingTask task2 = new ExceptionLeakingTask();
        ExceptionLeakingTask task3 = new ExceptionLeakingTask();
        ExceptionLeakingTask task4 = new ExceptionLeakingTask();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
