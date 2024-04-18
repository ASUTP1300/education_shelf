package multithread_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Collect {

    private static final int POOL_SIZE = 50;

    private static Integer n = 0;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        final CountDownLatch countDownLatch = new CountDownLatch(50);

        for (int i = 0; i < 500; i++) {
            executorService.submit(
                    () -> {
                        increment();
                        countDownLatch.countDown();
                    }
            );
        }


        countDownLatch.await();
        executorService.shutdown();
        System.out.println("КОНЕЦ " + n);

    }

    static synchronized void increment() {
        System.out.println("До synchronization " + n);
//        synchronized (n) {
            System.out.println("После synchronization " + n);
            int copy = n;
            n++;
            System.out.println("После synchronization инкремент" + n);
//        }
    }
}
