package section02_creating_and_running_threads.thread_api;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/12/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CreatingThreadsSecondWay {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ...");

        Thread t1 = new SecondTask();
        Thread t2 = new SecondTask();

        t1.start();
        t2.start();

        System.out.println("Main thread ends here ...");
    }

}

class SecondTask extends Thread {

    private static int count = 0;
    private int id;

    public SecondTask() {
        this.id = ++count;
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Thread " + id + " Tick Tock "+i);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
