package com.efficient_java_multithreading_with_executors.section02_creating_and_running_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 8/12/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class UsingSingleThreadExecutor {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();

        System.out.println("Main thread ends here ...");
    }

}
