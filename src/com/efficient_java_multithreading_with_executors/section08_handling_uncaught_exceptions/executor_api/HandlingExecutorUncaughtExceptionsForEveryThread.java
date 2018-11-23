package com.efficient_java_multithreading_with_executors.section08_handling_uncaught_exceptions.executor_api;

import com.efficient_java_multithreading_with_executors.common.ExceptionLeakingTask;
import com.efficient_java_multithreading_with_executors.common.ThreadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingExecutorUncaughtExceptionsForEveryThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());
        executorService1.execute(new ExceptionLeakingTask());

        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());
        executorService2.execute(new ExceptionLeakingTask());

        executorService1.shutdown();
        executorService2.shutdown();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
