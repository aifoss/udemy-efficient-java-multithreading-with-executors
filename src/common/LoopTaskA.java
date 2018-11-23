package common;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/12/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class LoopTaskA implements Runnable {

    private static int count = 0;
    private int id;

    public LoopTaskA() {
        id = ++count;
    }

    @Override
    public void run() {
        System.out.println("***** <TASK-" + id + "> STARTING *****");


        for (int i = 10; i > 0; i--) {
            System.out.println("<TASK-" + id + "> Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("***** <TASK-" + id + "> DONE *****");
    }

}
