package edu.spring_wf.collectors_;


import java.util.LinkedHashSet;
import java.util.Set;

public class Car {

    public static void main(String[] args) {
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
