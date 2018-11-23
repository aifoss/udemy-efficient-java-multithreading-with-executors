package com.efficient_java_multithreading_with_executors.common;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class DaemonThreadFactory extends NamedThreadFactory {

    private static int count = 0;

    public Thread newThread(Runnable r) {
        Thread t = super.newThread(r);

        count++;

        if (count % 2 == 0) {
            t.setDaemon(true);
        }

        return t;
    }

}
