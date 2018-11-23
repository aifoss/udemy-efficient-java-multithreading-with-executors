package section02_creating_and_running_threads.thread_api;

import java.util.concurrent.TimeUnit;

/**
 * Created by sofia on 8/12/18.
 */

/**
 * Sources:
 * Udemy: Efficient Java Multithreading with Executors
 */
public class CreatingThreadsFirstWay {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ...");

        Thread t1 = new FirstTask();
        Thread t2 = new FirstTask();

        System.out.println("Main thread ends here ...");
    }

}

class FirstTask extends Thread {

    private static int count = 0;
    private int id;

    public FirstTask() {
        this.id = ++count;
        this.start();
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
