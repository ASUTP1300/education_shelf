package it1;

import java.util.HashSet;
import java.util.Set;

/*
 * IT1
 * 09.11.23
 */

/**
 * Понимание работы Map
 */
public class UniqueSet {

    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();

        Person person1 = new Person("Руслан");
        Person person2 = new Person("Руслан");

        persons.add(person1);
        persons.add(person2);

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
