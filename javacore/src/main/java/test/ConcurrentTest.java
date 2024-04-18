package main.java.test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

/**
 * The main method demonstrates the usage of multithreading and shared resources in Java.
 * It creates two threads, th1 and th2, that increment a shared parameter in an instance of the Animal class.
 * The increment method is synchronized to prevent race conditions.
 * After both threads have finished execution, the main method prints the shared map.
 *
 * @throws InterruptedException If any thread is interrupted while waiting for another thread to finish.
 */
public class ConcurrentTest {
    public static void main(String[] args) throws InterruptedException {

        Animal animal = new Animal();

        List<Integer> list = new ArrayList<Integer>();

        Runnable runnable = animal::increment;

        Thread th1 = new Thread(() -> IntStream.range(1, 3000).forEach(i -> animal.increment()));

        Thread th2 = new Thread(() -> IntStream.range(1, 3000).forEach(i -> animal.increment()));

        th1.start();
        th2.start();
        th1.join();
        th2.join();


         list =  new ArrayList<>(Arrays.asList(1, 2, 3));
        for (Integer i : list) {
                list.add(i);
        }
    }

    static void test3(List<Integer> list) {
        list.stream().forEach(item -> {list.add(item + 1);
            System.out.println(Thread.currentThread());});
    }


    static class Animal {
        int param = 0;
        volatile int buf = 0;

        void increment() {
            check();
            check();
            check();
            check();
            check();
            check();
            param++;
            buf = param;
            check();
//            System.out.printf("Значение параметра %s, время %s, поток %s", param, LocalDateTime.now(), Thread.currentThread());
            System.out.println();
        }

        void check() {
            if (buf != param) {
                throw new ConcurrentModificationException("Кто-изменил param уже..(( " + param);
            }
        }


    }
}
