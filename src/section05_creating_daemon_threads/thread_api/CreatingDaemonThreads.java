package section05_creating_daemon_threads.thread_api;

import common.LoopTaskD;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CreatingDaemonThreads {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[" + currentThreadName + "] Main thread starts here ...");

        Thread t1 = new Thread(new LoopTaskD(500), "Thread-1");
        t1.setDaemon(true);

        Thread t2 = new Thread(new LoopTaskD(1000), "Thread-2");
//        t2.setDaemon(true);

        t1.start();
        t2.start();

        System.out.println("[" + currentThreadName + "] Main thread ends here ...");
    }

}
