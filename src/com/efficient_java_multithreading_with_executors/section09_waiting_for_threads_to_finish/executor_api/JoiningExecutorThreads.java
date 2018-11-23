package com.efficient_java_multithreading_with_executors.section09_waiting_for_threads_to_finish.executor_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskI;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class JoiningExecutorThreads {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        CountDownLatch doneSignal = new CountDownLatch(2);

        executorService.execute(new LoopTaskI(doneSignal));
        executorService.execute(new LoopTaskI(doneSignal));
        executorService.execute(new LoopTaskI(doneSignal));
        executorService.execute(new LoopTaskI(doneSignal));

        executorService.shutdown();

        try {
            doneSignal.await();
            System.out.println("[" + currentThreadName + "] GOT THE SIGNAL TO CONTINUE");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
