package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskD implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private long sleepTime;

    public LoopTaskD(long sleepTime) {
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskD" + instanceNumber;
    }

    @Override
    public void run() {
        boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();

        String threadType = isRunningInDaemonThread ? "DAEMON"  : "USER";

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("***** ["+ currentThreadName + ", " + threadType + "] <TASK-" + taskId + "> STARTING *****");


        for (int i = 10; i > 0; i--) {
            System.out.println("[" + currentThreadName+ ", " + threadType  + "] <TASK-" + taskId + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("***** [" + currentThreadName+ ", " + threadType  + "] <TASK-" + taskId + "> DONE *****");
    }

}
