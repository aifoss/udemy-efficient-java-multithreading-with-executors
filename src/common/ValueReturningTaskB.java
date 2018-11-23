package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ValueReturningTaskB implements Runnable {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private ResultListener<Integer> listener;

    public ValueReturningTaskB(int a, int b, long sleepTime, ResultListener<Integer> listener) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValueReturnTaskB-" + instanceNumber;

        this.listener = listener;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <" + taskId + "> Sleeping for " + sleepTime + " millis");

        try {
            TimeUnit.MICROSECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a + b;

        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> DONE #####");

        listener.notifyResult(sum);

    }

}
