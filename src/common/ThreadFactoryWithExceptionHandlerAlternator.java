package common;

/**
 * Created by sofia on 9/8/18.
 */
public class ThreadFactoryWithExceptionHandlerAlternator extends NamedThreadFactory {

    private int cnt = 0;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = super.newThread(r);

        if (++cnt % 2 == 0) {
            t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        }

        return t;
    }

}
