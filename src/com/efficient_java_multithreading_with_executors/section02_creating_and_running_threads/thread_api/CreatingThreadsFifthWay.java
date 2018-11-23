package com.efficient_java_multithreading_with_executors.section02_creating_and_running_threads.thread_api;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/12/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CreatingThreadsFifthWay {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ...");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println("Tick Tock "+i);

                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

        System.out.println("Main thread ends here ...");
    }


}
