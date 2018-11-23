package com.efficient_java_multithreading_with_executors.section06_checking_if_thread_is_alive.thread_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskC;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CheckingThreadsAlive {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread t1 = new Thread(new LoopTaskC(), "MyThread-1");
        Thread t2 = new Thread(new LoopTaskC(), "MyThread-2");

        boolean t1IsAlive = t1.isAlive();
        boolean t2IsAlive = t2.isAlive();

        System.out.println("[" + currentThreadName + "] BEFORE STARTING: " + t1.getName() + " alive? " + t1IsAlive);
        System.out.println("[" + currentThreadName + "] BEFORE STARTING: " + t2.getName() + " alive? " + t2IsAlive);

        t1.start();
        t2.start();

        while (true) {
            TimeUnit.MICROSECONDS.sleep(600);

            t1IsAlive = t1.isAlive();
            t2IsAlive = t2.isAlive();

            System.out.println("[" + currentThreadName + "] " + t1.getName() + " alive? " + t1IsAlive);
            System.out.println("[" + currentThreadName + "] " + t2.getName() + " alive? " + t2IsAlive);

            if (!t1IsAlive && !t2IsAlive) {
                break;
            }
        }

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
