package multithread_;

import java.util.concurrent.TimeUnit;
public class ResetInterruption implements Runnable {
    public static void main(final String[] args) throws Exception {
        final Thread thread = new Thread(new ResetInterruption());
        thread.start();
        thread.join();
        System.out.printf("Interrupted %b%n", thread.isInterrupted());
    }
    @Override
    public void run() {
        try {
            // The interrupted status of the current thread is cleared when InterruptedException is thrown by sleep() method.
            TimeUnit.SECONDS.sleep(1);

            System.out.printf(" До - Interrupted %b%n", Thread.currentThread().isInterrupted());
            throw new InterruptedException("Что-то пошло не  так");
        } catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.printf(" После - Interrupted %b%n", Thread.currentThread().isInterrupted());
        }
    }
}