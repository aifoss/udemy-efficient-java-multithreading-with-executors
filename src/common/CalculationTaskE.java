package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by sofia on 9/9/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CalculationTaskE implements Callable<Long> {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private static final int DATA_SIZE = 100000;

    private boolean isThreadInterrupted = false;

    public CalculationTaskE() {
        this.instanceNumber = ++count;
        this.taskId = "CalculationTaskE" + instanceNumber;
    }

    @Override
    public Long call() {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");

        long totalTimeTakenInMillis = 0;


        for (int i = 0; i < 10; i++) {
//            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> CURRENT RUNNING AVERAGE = " +
//                    (i == 0 ? 0 : totalTimeTakenInMillis / (2*i)));

            long timeTakenInMillis = doSomeWork();
            totalTimeTakenInMillis += timeTakenInMillis;

            if (Thread.interrupted()) {
//                System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Interrupted. Cancelling ...");
                isThreadInterrupted = true;
                break;
            }

        }

//        System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Retrieving 'INTERRUPTED' status again: " + Thread.interrupted());

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");

        return isThreadInterrupted ? -1 : totalTimeTakenInMillis / (2*10);
    }

    private long doSomeWork() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 2; i++) {
            Collections.sort(generateDataSet());
        }

        return System.currentTimeMillis() - startTime;
    }

    private List<Integer> generateDataSet() {
        List<Integer> intList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < DATA_SIZE; i++) {
            intList.add(random.nextInt(DATA_SIZE));
        }


        return intList;
    }

}
