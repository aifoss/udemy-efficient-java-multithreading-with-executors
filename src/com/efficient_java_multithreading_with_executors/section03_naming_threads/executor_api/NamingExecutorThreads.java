package com.efficient_java_multithreading_with_executors.section03_naming_threads.executor_api;

import com.efficient_java_multithreading_with_executors.common.LoopTaskC;
import com.efficient_java_multithreading_with_executors.common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 8/18/18.
 */
public class NamingExecutorThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        ExecutorService executorService2 = Executors.newCachedThreadPool(new NamedThreadFactory());
        executorService2.execute(new LoopTaskC());
        executorService2.execute(new LoopTaskC());
        executorService2.execute(new LoopTaskC());

        executorService.shutdown();
        executorService2.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
