import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Reactor {
    public static void main(String[] args) throws InterruptedException {


//        Part01Flux part01Flux = new Part01Flux();
//        part01Flux.counter().take(10).subscribe(System.out::println);
       ParallelFlux<Long> f = Flux.fromIterable(List.of(1L, 2L)).parallel();

       f.map(n ->  n * 2).subscribe(System.out::println);
       f.map(n ->  n * 3).subscribe(System.out::println);

    }

    static class Part01Flux {

        // TODO Return an empty Flux
        Flux<String> emptyFlux() {
            return Flux.empty();
        }

        // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
        Flux<String> fooBarFluxFromValues() {
            return Flux.just("foo", "bar");
        }


        // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
        Flux<String> fooBarFluxFromList() {
            return Flux.fromIterable(List.of("foo", "bar"));
        }

        // TODO Create a Flux that emits an IllegalStateException
        Flux<String> errorFlux() {
            return Flux.error(new IllegalStateException());
        }

        // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
        Flux<Long> counter() {
            return Flux.interval(Duration.of(100L, ChronoUnit.MILLIS));
        }

    }

}
