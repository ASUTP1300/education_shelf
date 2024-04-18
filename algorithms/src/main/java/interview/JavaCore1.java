package interview;


import java.util.HashSet;
import java.util.Set;

public class JavaCore1 {

        public static void main(String[] args) {
            Set<Person> persons = new HashSet<>();

            Person person1 = new Person("Иван");
            Person person2 = new Person("Иван");

            persons.add(person1);
            persons.add(person2);

            //Что напечатает...
            System.out.println(persons);
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
    }
