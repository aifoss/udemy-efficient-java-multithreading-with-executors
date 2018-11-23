package section08_handling_uncaught_exceptions.thread_api;

import common.ExceptionLeakingTask;
import common.ThreadExceptionHandler;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingUncaughtExceptionsDifferentlyForEachThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");
        t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
        t2.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        Thread t3 = new Thread(new ExceptionLeakingTask(), "MyThread-3");
        t3.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        Thread t4 = new Thread(new ExceptionLeakingTask(), "MyThread-4");
        t4.setUncaughtExceptionHandler(new ThreadExceptionHandler());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
