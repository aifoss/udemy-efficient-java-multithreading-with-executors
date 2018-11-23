package common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskI implements Runnable {

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private CountDownLatch doneCountLatch;

    public LoopTaskI(CountDownLatch doneCountLatch) {
        this.doneCountLatch = doneCountLatch;
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskI" + instanceNumber;
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
                TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("***** [" + currentThreadName+ ", " + threadType  + "] <TASK-" + taskId + "> DONE *****");

        if (doneCountLatch != null) {
            doneCountLatch.countDown();

            System.out.println("***** [" + currentThreadName + ", " + threadType + "] <TASK-" + taskId + "> COUNT = " + doneCountLatch.getCount());

        }
    }

}
