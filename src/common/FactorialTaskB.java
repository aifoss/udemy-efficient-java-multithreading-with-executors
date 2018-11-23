package common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class FactorialTaskB implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private long a;
    private long factorial;
    private long sleepTime;

    public FactorialTaskB(long a, long sleepTime) {
        this.a = a;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "FactorialTaskB" + instanceNumber;
    }

    @Override
    public Long call() {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");

        factorial = 1L;


        for (long i = 1; i <= a; i++) {
            factorial *= i;

            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Iteration-" + i + ", Intermediate Result = " + factorial);

            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> Sleep interrupted. Cancelling ...");
                factorial = -1L;
                break;
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");

        return factorial;
    }

}
