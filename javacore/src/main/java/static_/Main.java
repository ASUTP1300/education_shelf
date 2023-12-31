package static_;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Пример изменения объекта
 */
public class Main {

    final static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Байкал";

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        System.out.println("До : " + dogs);

        dog.name = "Гром";

        System.out.println("После : " + dogs);
    }

    static  class  Section {
        Map<String, Integer> map;

        public Section(Map<String, Integer> map) {
            this.map = map;
        }

        public void putInSectionMap(String name, Integer age) {
            map.put(name, age);
        }

        @Override
        public String toString() {
            return "Section{" +
                    "map=" + map +
                    '}';
        }
    }

    static class TextSection extends Section{

        String text;

        public TextSection(Map<String, Integer> map) {
            super(map);
        }
    }

    static class ListSection extends Section{
        List<String> list;

        public ListSection(Map<String, Integer> map) {
            super(map);
        }
    }
}
class Dog {
    String name;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}