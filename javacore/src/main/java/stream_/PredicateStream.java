package stream_;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateStream {
    public static void main(String[] args) {
        String[] names = {"Java", "Kotlin", "Java"};
        String name = "Java";

        Predicate predicate = name::equals;

        System.out.println(Stream.of(names).filter(predicate).count());

        name = "Uzbek";

        System.out.println(Stream.of(names).filter(predicate).count());
    }
}
