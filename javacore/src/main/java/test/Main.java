package main.java.test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/*
    Задача на многопоточность

 */
public class Main {
    static final List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws InterruptedException {

//        Runnable task = () -> {
//            IntStream.range(1, 300).forEach(list::add);
//            System.out.println(list);
//        };

        Thread th1 = new Thread(() -> {
            IntStream.range(0, 300).forEach(list::add);
            System.out.println(list);
        });

        Thread th2 = new Thread(() -> {
            IntStream.range(0, 300).forEach(list::add);
            System.out.println(list);
        });


        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println(list.size());
    }

}
