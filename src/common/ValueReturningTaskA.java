package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ValueReturningTaskA implements Runnable {

    private static int count = 0;

    private int instanceNumber;
    private String taskId;

    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private volatile boolean done = false;

    public ValueReturningTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

        this.instanceNumber = ++count;
        this.taskId = "ValueReturnTaskA-" + instanceNumber;

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

        done = true;

        synchronized (this) {
            System.out.println("[" + currentThreadName + "] <" + taskId + "> WAITING ...");
            this.notifyAll();
        }
    }

    public int getSum() {
        if (!done) {
            synchronized (this) {
                try {
                    System.out.println("[" + Thread.currentThread().getName() + "] WAITING for result from " + taskId + " ...");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[" + Thread.currentThread().getName() + "] WOKEN UP for " + taskId + " ...");
        }
        return sum;
    }

}
