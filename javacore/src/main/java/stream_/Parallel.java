package stream_;

import java.util.stream.IntStream;

public class Parallel {
    static long start = 0;
    static long stop = 0;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        sequentialProcess();
        stop = System.currentTimeMillis();

        System.out.println("Время выполнения последовательного стрима " + (stop - start));


        start = System.currentTimeMillis();
        parallelProcess();
        stop = System.currentTimeMillis();

        System.out.println("Время выполнения параллельного стрима " + (stop - start));

    }

    static void sequentialProcess(){
        IntStream.range(0, 100).sum();
    }

    static void parallelProcess(){
        IntStream.range(0, 100).parallel().sum();
    }
}


