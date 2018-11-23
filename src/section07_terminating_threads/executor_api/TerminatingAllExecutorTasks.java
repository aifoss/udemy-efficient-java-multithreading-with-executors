package section07_terminating_threads.executor_api;

import common.CalculationTaskB;
import common.CalculationTaskC;
import common.FactorialTaskB;
import common.LoopTaskA;
import common.LoopTaskF;
import common.NamedThreadFactory;
import common.TaskResult;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class TerminatingAllExecutorTasks {

    public static void main(String[] args) throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        LoopTaskA task1 = new LoopTaskA();
        LoopTaskF task2 = new LoopTaskF();
        FactorialTaskB task3 = new FactorialTaskB(30, 500);
        CalculationTaskC task4 = new CalculationTaskC();
        CalculationTaskB task5 = new CalculationTaskB(2, 3, 90000);

        executorService.execute(task1);
        executorService.execute(task2);
        Future<Long> f3 = executorService.submit(task3);
        Future<Long> f4 = executorService.submit(task4);
        Future<TaskResult> f5 = executorService.submit(task5);

        TimeUnit.MILLISECONDS.sleep(3);

        executorService.shutdownNow();

        System.out.println("[" + currentThreadName + "] ALL TASKS TERMINATED = " +
                executorService.awaitTermination(5000, TimeUnit.MICROSECONDS));

        System.out.println("[" + currentThreadName + "] 'FactorialTaskB1' result = " + f3.get());
        System.out.println("[" + currentThreadName + "] 'CalculationTaskC1' result = " + f4.get());
        try {
            System.out.println("[" + currentThreadName + "] 'CalculationTaskB1' result = " + f5.get());
        } catch (ExecutionException e) {
            System.out.println("[" + currentThreadName + "] 'CalculationTaskB1' result = Got ExecutionException. Cause: \n");
            e.getCause().printStackTrace();
        }

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
