package interview;

import java.util.*;
import java.util.function.Predicate;


//Итератор
public class Main {
    // todo: implement

    static class IteratorWithFilter<E> implements Iterator<E> {

        private final Iterator<E> iterator;
        private final Predicate<E> filter;

        private E current;

        public IteratorWithFilter(Iterator<E> iterator, Predicate<E> filter) {
            this.iterator = iterator;
            this.filter = filter;
        }

        @Override
        public boolean hasNext() {
            E buf = null;

            if (current == null) {
                while (iterator.hasNext()) {

                    if (filter.test(buf = iterator.next())) {
                        current = buf;
                        return true;
                    }
                }
                return false;
            }

            return true;
        }

        @Override
        public E next() {
            E buf = null;

            if (this.hasNext()) {
                buf = current;
                current = null;
                return buf;
            }
            throw new NoSuchElementException("No more elements in the iterator");
        }

    }


    public static void main(String... args) {

        var iterator = List.of(1, 2, 3, 4, 5, 6, 7)
                .iterator();

        var wrapper = new IteratorWithFilter<>(iterator, e -> e % 2 == 0);

        while (wrapper.hasNext()) {
            System.out.println(wrapper.next());
        }
      /* ожидаемый вывод
      2
      4
      6
      */
    }
}
