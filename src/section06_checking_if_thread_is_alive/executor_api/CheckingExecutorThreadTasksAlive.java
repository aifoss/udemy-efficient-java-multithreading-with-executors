package section06_checking_if_thread_is_alive.executor_api;

import common.CalculationTaskA;
import common.LoopTaskC;
import common.NamedThreadFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CheckingExecutorThreadTasksAlive {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        Future<?> f1 = executorService.submit(new LoopTaskC());
        Future<Integer> f2 = executorService.submit(new CalculationTaskA(3, 4, 700));

        FutureTask<?> f3 = new FutureTask<Void>(new LoopTaskC(), null);
        FutureTask<Integer> f4 = new FutureTask<>(new LoopTaskC(), 999);
        FutureTask<Integer> f5 = new FutureTask<>(new CalculationTaskA(4, 5, 500));

        executorService.execute(f3);
        executorService.execute(f4);
        executorService.execute(f5);

        executorService.shutdown();

        System.out.println("[" + currentThreadName + "] -> LoopTask-1 done? " + f1.isDone());
        System.out.println("[" + currentThreadName + "] -> CalcTask-1 done? " + f2.isDone());
        System.out.println("[" + currentThreadName + "] -> LoopTask-2 done? " + f3.isDone());
        System.out.println("[" + currentThreadName + "] -> LoopTask-3 done? " + f4.isDone());
        System.out.println("[" + currentThreadName + "] -> CalcTask-2 done? " + f5.isDone());

        for (int i = 0; i < 5; i++) {
            System.out.println("[" + currentThreadName + "] ITR-" + i + " -> LoopTask-1 done? " + f1.isDone());
            System.out.println("[" + currentThreadName + "] ITR-" + i + " -> CalcTask-1 done? " + f2.isDone());
            System.out.println("[" + currentThreadName + "] ITR-" + i + " -> LoopTask-2 done? " + f3.isDone());
            System.out.println("[" + currentThreadName + "] ITR-" + i + " -> LoopTask-3 done? " + f4.isDone());
            System.out.println("[" + currentThreadName + "] ITR-" + i + " -> CalcTask-2 done? " + f5.isDone());
        }


        System.out.println("[" + currentThreadName + "] -> LoopTask-1 done? " + f1.isDone());
        System.out.println("[" + currentThreadName + "] -> CalcTask-1 done? " + f2.isDone());
        System.out.println("[" + currentThreadName + "] -> LoopTask-2 done? " + f3.isDone());
        System.out.println("[" + currentThreadName + "] -> LoopTask-3 done? " + f4.isDone());
        System.out.println("[" + currentThreadName + "] -> CalcTask-2 done? " + f5.isDone());

        System.out.println("$$$$$ [" + currentThreadName + "] Retrieving results now ... $$$$$");

        System.out.println("[" + currentThreadName + "] LoopTask-1 result = " + f1.get());
        System.out.println("[" + currentThreadName + "] CalTask-1 result = " + f2.get());
        System.out.println("[" + currentThreadName + "] LoopTask-2 result = " + f3.get());
        System.out.println("[" + currentThreadName + "] LoopTask-3 result = " + f4.get());
        System.out.println("[" + currentThreadName + "] CalTask-2 result = " + f5.get());

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }
    
}
