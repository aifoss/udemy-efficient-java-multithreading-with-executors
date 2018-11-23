package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskH implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private boolean sleepInterrupted = false;

    public LoopTaskH() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskH" + instanceNumber;
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
                System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Sleep interrupted. SETTING THE FLAG ...");
                sleepInterrupted = true;
            }

            doSomeMoreWork();

            if (sleepInterrupted || Thread.interrupted()) {
                System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> INTERRUPTED. Cancelling ...");
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
    }

    private void doSomeMoreWork() {
        System.out.println("***** [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> DOING SOME MORE WORK ...");
    }

}
