package common;

/**
 * Created by sofia on 9/8/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String handlerId;

    public ThreadExceptionHandler() {

    }

    public ThreadExceptionHandler(String handlerId) {
        this.handlerId = handlerId;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(this + " caught exception in Thread " + t.getName() + ": " + e);

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + this.hashCode() +
                ((handlerId == null || handlerId.equals("")) ? "" : ("\"" + handlerId + "\")"));
    }

}
