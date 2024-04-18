package multithread_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafe {
    public static class ThreadSafe4 {
        private List<String> recipe = new ArrayList<>();
        private final Lock lock = new ReentrantLock();

        public void add(final String ingredient) {
            lock.lock();

            recipe.add(ingredient);

            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
