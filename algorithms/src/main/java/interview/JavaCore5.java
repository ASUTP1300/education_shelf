package src.main.java.interview;


import java.util.*;

public class JavaCore5 {

    static String ARFIX = "ARFIX";

        public static void main(String[] args) {

            System.out.println(A.A == A.A);
            Set<Person> persons = new HashSet<>();

            Map<String, Person> map = new HashMap<>();

            Person person1 = new Person("Иван");
            Person person2 = new Person("Руслан");


            Optional<Person> person = Optional.of(person1);

            person.map(Person:: getName);


            map.put("ARFIX-PAYORDER", person1);

            map.keySet().stream().filter(k -> k.contains(ARFIX)).map(map::get).forEach(System.out::println);

        }

        static class Person {
           public String name;

            public String getName() {
                return name;
            }

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
