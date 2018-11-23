package common;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ThreadFactoryWithExceptionHandler extends NamedThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = super.newThread(r);
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return t;
    }

}
