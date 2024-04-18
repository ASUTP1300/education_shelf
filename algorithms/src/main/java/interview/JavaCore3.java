package interview;

import java.util.ArrayList;
import java.util.List;

public class JavaCore3 {

    final static String COW_ANIMAL = "Корова";
    final static String CHICKEN = "Куро4ка";

    public static void main(String[] args) {

        Cow cow1 = new Cow("Петя", 230L);
        Cow cow2 = new Cow("Костя", 500L);

        Chicken chicken1 = new Chicken("Коля", 1L);
        Chicken chicken2 = new Chicken("Глеб", 1L);

        Animal animal1 = cow1;
        Animal animal2 = chicken1;

        System.out.println(animal1);
        System.out.println(animal2);




        //add to native collection
        List<Cow> cows = new ArrayList<>();
        cows.add(cow1);

        List<Chicken> chickens = new ArrayList<>();
        chickens.add(chicken1);


//        List<? super Animal> animals = cows;


        read(cows);
        read(chickens);

//        write(cows);
//        write(chickens);




    }


    static void read(List<? extends  Animal> list) {
        list.forEach(System.out::println);
    }

    static void write(List<? super  Animal> list) {
        list.add(new Animal("Псина", 2L));
        System.out.println(list);
    }

    static class Animal {
        final String name;
        final Long weight;

        public Animal(String name, Long weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Cow extends Animal {
        final String owner;


        public Cow(String owner, Long weight) {
            super(COW_ANIMAL, weight);
            this.owner = owner;
        }

        @Override
        public String toString() {
            return   "{" + '\n' +
                     "Владелец='" + owner + '\n' +
                     "Животное" + super.toString() + '\n' +
                      '}';
        }
    }


    static class Chicken extends Animal {
        final String owner;

        public Chicken(String owner, Long weight) {
            super(CHICKEN, weight);
            this.owner = owner;
        }

        @Override
        public String toString() {
            return   "{" + '\n' +
                    "Владелец='" + owner + '\n' +
                    "Животное" + super.toString() + '\n' +
                    '}';
        }
    }




}
