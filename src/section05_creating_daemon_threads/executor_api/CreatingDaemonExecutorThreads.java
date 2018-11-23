package section05_creating_daemon_threads.executor_api;

import common.DaemonThreadFactory;
import common.LoopTaskD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CreatingDaemonExecutorThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());

        executorService.submit(new LoopTaskD(100));
        executorService.submit(new LoopTaskD(200));
        executorService.submit(new LoopTaskD(300));
        executorService.submit(new LoopTaskD(400));

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
