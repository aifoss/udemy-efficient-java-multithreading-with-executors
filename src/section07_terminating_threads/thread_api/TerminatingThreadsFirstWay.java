package section07_terminating_threads.thread_api;

import common.LoopTaskE;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class TerminatingThreadsFirstWay {

    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        LoopTaskE task1 = new LoopTaskE();
        LoopTaskE task2 = new LoopTaskE();
        LoopTaskE task3 = new LoopTaskE();

        new Thread(task1, "MyThread-1").start();
        new Thread(task2, "MyThread-2").start();
        new Thread(task3, "MyThread-3").start();

        TimeUnit.MILLISECONDS.sleep(1);

        task1.cancel();
        task2.cancel();
        task3.cancel();

        System.out.println("[" + currentThreadName + "] Main threads ends here");
    }

}
