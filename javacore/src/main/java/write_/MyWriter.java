package write_;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyWriter {

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        System.out.println(List.of(person1, person2, person3));

    }
}


class Person {
    static AtomicInteger i = new AtomicInteger(1);
    static long getId() {
        if (i.get() == 1) {
            i.incrementAndGet();
            return 1;
        }

        return i.incrementAndGet();
    }

    private final Long id;

    public Person() {
        this.id = Person.getId();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
    //hashcode
    //equals
}