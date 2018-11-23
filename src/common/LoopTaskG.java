package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskG implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskG() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskG" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 0; i < 10; i++) {
            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*3000000);
            } catch (InterruptedException e) {
                System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Sleep interrupted. Cancelling ...");
                break;
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
    }

}
