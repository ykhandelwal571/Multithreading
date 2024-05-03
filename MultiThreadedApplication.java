package Level2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadedApplication {
    private static final int NUM_THREADS = 5;
    private static final int NUM_ITERATIONS = 10;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        for (int i = 0; i < NUM_THREADS; i++) {
            Runnable task = new Worker(lock);
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Lock lock;

        public Worker(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " is working on iteration " + (i + 1));
                   
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
