package src.main.java.interview;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaCore4 {

    static String ARFIX = "ARFIX";

        public static void main(String[] args) {

            System.out.println(A.A == A.A);
            Set<Person> persons = new HashSet<>();

            Map<String, Person> map = new HashMap<>();

            Person person1 = new Person("Иван");
            Person person2 = new Person("Руслан");

            map.put("ARFIX-PAYORDER", person1);

            map.keySet().stream().filter(k -> k.contains(ARFIX)).map(map::get).forEach(System.out::println);

        }

        static class Person {
            String name;

            public Person(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object obj) {
                Person p = (Person) obj;
                return p.name.equals(this.name);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        '}';
            }

        }

        enum  A {
            A,
            B,
            C,
            D,

    }
    }
