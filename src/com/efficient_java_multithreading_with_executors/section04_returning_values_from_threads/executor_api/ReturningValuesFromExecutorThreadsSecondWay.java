package com.efficient_java_multithreading_with_executors.section04_returning_values_from_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.CalculationTaskB;
import com.efficient_java_multithreading_with_executors.common.LoopTaskB;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;
import com.efficient_java_multithreading_with_executors.common.TaskResult;

import java.util.concurrent.*;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ReturningValuesFromExecutorThreadsSecondWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        CompletionService<TaskResult> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(new CalculationTaskB(2, 3, 2000));
        completionService.submit(new CalculationTaskB(3, 4, 1000));
        completionService.submit(new CalculationTaskB(4, 5, 500));

        completionService.submit(new LoopTaskB(), new TaskResult<>("LoopTaskA-1", 999));

        executorService.shutdown();

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
