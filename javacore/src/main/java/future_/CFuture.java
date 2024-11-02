package future_;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CFuture {



    public static void main(String[] args) throws InterruptedException {

//        CompletableFuture<Void> cf1 = CompletableFuture
//                .runAsync(() -> IntStream.range(0, 10)
//                        .boxed()
//                        .map(j -> "Число i " + i++).forEach(System.out::println));
//        Thread.sleep(5000);
//        CompletableFuture<CompletableFuture<Void>> cf2 = cf1.thenApply(System.out::println);
//        System.out.println("Число i без CFC " + i);
        final int[] i = {0};

        //Бесполезная работа
        Supplier<Integer> run = () -> IntStream.range(0, 1_00).map(ii -> 1)
                .peek(r -> System.out.printf("Число во CFUTURE %s \n", r))
                .reduce(0, Integer::sum);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(run);


        CompletableFuture.supplyAsync(run).thenAcceptAsync(integer ->
        {
            System.out.println("До COMPLETABLE_FUTURE i = " + i[0]);
            i[0] = integer;
            System.out.println(" Из COMPLETABLE_FUTURE i = " + i[0]);

        });


        while (i[0] < 1_000) {
            System.out.println("i = " + i[0]);
            i[0]++;
        }

        System.out.println("Конец " + i[0]);
    }
}
