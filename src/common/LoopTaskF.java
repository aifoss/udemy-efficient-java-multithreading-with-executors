package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskF implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private static final int DATA_SIZE = 100000;

    public LoopTaskF() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskF" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 0; ; i++) {
            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Tick Tock " + i);

            doSomeWork();

            if (Thread.interrupted()) {
                System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Interrupted. Cancelling ...");
                break;
            }

        }

        System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Retrieving 'INTERRUPTED' status again: " + Thread.interrupted());

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
    }

    private void doSomeWork() {
        for (int i = 0; i < 2; i++) {
            Collections.sort(generateDataSet());
        }
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
