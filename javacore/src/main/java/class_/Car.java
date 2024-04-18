package class_;



import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Car {

    public static void main(String[] args) {


        System.out.println(Stream.of(1, 2,3).peek(System.out::println).count());

        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
    }

    void checkEngine(){
        System.out.println("Проверка двигателя");
    }

    void speed(String speed) {
        System.out.println("Ohhh, " + speed);
    }
}
