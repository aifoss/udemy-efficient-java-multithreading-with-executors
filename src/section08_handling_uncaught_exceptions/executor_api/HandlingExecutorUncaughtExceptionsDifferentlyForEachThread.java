package section08_handling_uncaught_exceptions.executor_api;

import common.ExceptionLeakingTask;
import common.ThreadFactoryWithExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class HandlingExecutorUncaughtExceptionsDifferentlyForEachThread {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());

        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());
        executorService.execute(new ExceptionLeakingTask());

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
