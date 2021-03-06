package com.efficient_java_multithreading_with_executors.section04_returning_values_from_threads.thread_api;

import com.efficient_java_multithreading_with_executors.common.ValueReturningTaskA;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ReturningValuesFromThreadsFirstWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ValueReturningTaskA task1 = new ValueReturningTaskA(2, 3, 200);
        Thread t1 = new Thread(task1, "Thread-1");

        ValueReturningTaskA task2 = new ValueReturningTaskA(3, 4, 1000);
        Thread t2 = new Thread(task2, "Thread-2");

        ValueReturningTaskA task3 = new ValueReturningTaskA(4, 5, 500);
        Thread t3 = new Thread(task3, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Result-1 = " + task1.getSum());
        System.out.println("Result-2 = " + task2.getSum());
        System.out.println("Result-3 = " + task3.getSum());

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
