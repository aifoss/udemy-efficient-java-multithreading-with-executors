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
public class HandlingUncaughtExceptionsDefaultsAndOverrides {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT"));


        Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");

        Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
        t2.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom-1"));

        Thread t3 = new Thread(new ExceptionLeakingTask(), "MyThread-3");

        Thread t4 = new Thread(new ExceptionLeakingTask(), "MyThread-4");
        t4.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom-2"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
