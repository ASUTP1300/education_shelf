//package multithread_;
//
//import java.util.Random;
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.CyclicBarrier;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.locks.Lock;
//import java.util.function.Consumer;ublic class ThreadSafe5Quiz {
//    private static final int POOL_SIZE = 50;
//    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
//    public static void main(final String[] args) throws Exception {
//        final CyclicBarrier barrier = new CyclicBarrier(POOL_SIZE);
//        final CountDownLatch done = new CountDownLatch(POOL_SIZE);
//        final ThreadSafe5 account = new ThreadSafe5(100);
//        final Random random = new Random(41);
//        for (int i = 0; i < POOL_SIZE; i++) {
//            run(random.nextInt() % 3 == 0
//                            ? account::deposit
//                            : account::withdraw,
//                    Math.abs(random.nextInt(100)),
//                    barrier,
//                    done);
//        }
//        done.await();
//        System.out.printf("Account balance is %d%n", account.getBalance());
//        EXECUTOR.shutdown();
//    }
//    private static Future< ? > run(
//            final Consumer< Integer > operation, final int amount, final CyclicBarrier barrier, final CountDownLatch done) {
//        return EXECUTOR.submit(() -> {
//            try {
//                barrier.await();
//            } catch (final InterruptedException | BrokenBarrierException ex) {
//                throw new RuntimeException(ex);
//            }
//            operation.accept(amount);
//            done.countDown();
//        });
//    }
//    public static class ThreadSafe5 {
//        // Tip: always prefer "weakened" type for the declaration, i.e. List instead of ArrayList, as an example.
//        private final
//        lock = new
//                ();
//        private final Lock r = lock.readLock();
//        private final Lock w = lock.writeLock();
//        private int balance;
//        public ThreadSafe5(final int balance) {
//            this.balance = balance;
//        }
//        public void withdraw(final int amount) {
//
//            Выбрать:
// .
//            Выбрать:
//            ;
//            try {
//                System.out.printf("Withdraw %d%n", amount);
//                if (balance >= amount) {
//                    balance -= amount;
//                }
//            } finally {
//
//                Выбрать:
// .
//                Выбрать:
//                ;
//            }
//        }
//        public void deposit(final int amount) {
//            try {
//                System.out.printf("Deposit %d%n", amount);
//                balance += amount;
//            } finally {
//
//            }
//        }
//        public int getBalance() {
//
//            try {
//                return balance;
//            } finally {
//
//            }
//        }
//    }
//}