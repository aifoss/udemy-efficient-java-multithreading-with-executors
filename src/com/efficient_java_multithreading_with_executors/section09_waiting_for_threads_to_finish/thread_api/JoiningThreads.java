package com.efficient_java_multithreading_with_executors.section09_waiting_for_threads_to_finish.thread_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskD;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class JoiningThreads {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread t1 = new Thread(new LoopTaskD(100), "MyThread-1");
        Thread t2 = new Thread(new LoopTaskD(200), "MyThread-2");
        Thread t3 = new Thread(new LoopTaskD(500), "MyThread-3");
        Thread t4 = new Thread(new LoopTaskD(400), "MyThread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        System.out.println("[" + currentThreadName + "] Joined " + t1.getName());

        t2.join();
        System.out.println("[" + currentThreadName + "] Joined " + t2.getName());

        t3.join();
        System.out.println("[" + currentThreadName + "] Joined " + t3.getName());

        t4.join();
        System.out.println("[" + currentThreadName + "] Joined " + t4.getName());


        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
