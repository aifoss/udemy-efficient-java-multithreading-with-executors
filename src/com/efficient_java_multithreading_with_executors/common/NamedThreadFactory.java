package com.efficient_java_multithreading_with_executors.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sofia on 8/18/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class NamedThreadFactory implements ThreadFactory {

    private static AtomicInteger count = new AtomicInteger();
    private static final String NAME = "MyThread-";

    @Override
    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r, NAME + count.incrementAndGet());
        Thread t = new Thread(r);
        t.setName(NAME + count.incrementAndGet());

        return t;
    }

}
