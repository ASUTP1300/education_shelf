package it1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;


/*
 * IT1
 * 09.11.23
 */

/**
 * Возвращает Map значений из входящего списка на количество их повторений в списке
 * 1 1  2 2 2
 * Для
 * 1 , 2 , 4, 2, 1, 5, 8, 1
 * Вернет, например
 * {1,3} {2, 2} {4, 1} {5, 1} {8, 1}
 */
public class CountSameNumber {

    public static Map<Integer, Integer> countNumber(List<Integer> input) {
        Map<Integer, Integer> map = new HashMap<>();

        input.forEach(n -> {
            int count;
            if (map.containsKey(n)) {
                count = map.get(n);
                map.put(n, ++count);
            } else {
                map.put(n, 1);
            }
        });
        return map;
    }

    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 2, 1, 5, 8, 1));
        list.add(null);
        list.add(null);
        System.out.println(countNumber(list));
    }
}
