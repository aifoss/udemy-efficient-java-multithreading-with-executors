package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskE implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private volatile boolean shutdown = false;

    public LoopTaskE() {
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskE" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();


        System.out.println("***** ["+ currentThreadName + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 0; ; i++) {
            System.out.println("[" + currentThreadName + "] <TASK-" + taskId + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                if (shutdown) {
                    break;
                }
            }
        }

        System.out.println("***** [" + currentThreadName + "] <TASK-" + taskId + "> DONE *****");
    }

    public void cancel() {
        System.out.println("***** [" + Thread.currentThread().getName() + "] <" + taskId + "> Shutting down *****");

        synchronized (this) {
            this.shutdown = true;
        }
    }

}
