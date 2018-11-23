package common;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ExceptionLeakingTask implements Runnable {


    @Override
    public void run() {
        throw new RuntimeException();
    }

}
