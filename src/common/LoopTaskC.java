package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskC implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public LoopTaskC() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskC" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

//        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");
        System.out.println("***** ["+ Thread.currentThread().getName() + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 10; i > 0; i--) {
//            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Tick Tock "+i);
            System.out.println("[" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
        System.out.println("***** [" + Thread.currentThread().getName() + "] <TASK-" + taskId + "> DONE *****");
    }

}
