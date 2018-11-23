package section03_naming_threads.thread_api;

import common.LoopTaskB;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class NamingThreadsFirstWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        new Thread(new LoopTaskB()).start();

        Thread t2 = new Thread(new LoopTaskB());
        t2.start();

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
