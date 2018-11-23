package com.efficient_java_multithreading_with_executors.section11_exercises;

import com.efficient_java_multithreading_with_executors.common.CalculationTaskE;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class Exercise1 {

    private static final int INITIAL_NUM_THREADS = 3;
    private static final int NUM_THREAD_INCREMENT = 3;
    private static final int NUM_TASKS = 500;

    static Map<Integer, Double> statMap;

    static {
        statMap = new HashMap<>();
    }

    public static void main(String[] args) throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        int currentThreadPoolSize = INITIAL_NUM_THREADS;

        double lastExecutionTime = Double.POSITIVE_INFINITY;
        double currentExecutionTime = 100000;

        while (currentExecutionTime <= lastExecutionTime) {
            currentExecutionTime = run(currentThreadPoolSize);

            if (currentExecutionTime > lastExecutionTime) {
                break;
            }

            lastExecutionTime = currentExecutionTime;
            currentThreadPoolSize += NUM_THREAD_INCREMENT;
        }

//        int currentThreadPoolSize = 3;
//        run(currentThreadPoolSize);

        System.out.println("STATS:");

        for (Map.Entry<Integer, Double> entry : statMap.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

    public static double run(int threadPoolSize) throws Exception {
        System.out.println("=================================================================");
        System.out.println("***** RUN with " + threadPoolSize + " threads STARTING ... *****");

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize, new NamedThreadFactory());

        long totalTimeTakenInMillis = 0;

        for (int i = 0; i < NUM_TASKS; i++) {
            Future<Long> future = executorService.submit(new CalculationTaskE());
            totalTimeTakenInMillis += future.get();
        }

        executorService.shutdown();

        double totalTimeTakenInSeconds = (double) (totalTimeTakenInMillis / 1000);

        statMap.put(threadPoolSize, totalTimeTakenInSeconds);

        System.out.println("***** RUN with " + threadPoolSize + " threads FINISHED *****");
        System.out.println("=================================================================\n");

        return totalTimeTakenInSeconds;
    }

}
