package com.efficient_java_multithreading_with_executors.section08_handling_uncaught_exceptions.thread_api;

import com.efficient_java_multithreading_with_executors.common.ExceptionLeakingTask;
import com.efficient_java_multithreading_with_executors.common.ThreadExceptionHandler;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingUncaughtExceptionsForEveryThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));

        new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
        new Thread(new ExceptionLeakingTask(), "MyThread-4").start();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
