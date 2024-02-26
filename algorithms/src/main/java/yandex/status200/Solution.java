package yandex.status200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<Integer> integers1 = List.of(203, 404, 204, 200, 403);
        List<Integer> integers2 = List.of(1000000);
        List<Integer> integers3 = List.of(2022, 2020, 2021);
        List<Integer> integers4 = List.of(404, 2020, 204);

        System.out.println( "Результат 1 " + getNumberOfGoodPairs(1, integers1));
        System.out.println( "Результат 2 " + getNumberOfGoodPairs(1, integers2));
        System.out.println( "Результат 3 " + getNumberOfGoodPairs(1, integers3));
        System.out.println( "Результат 4 " + getNumberOfGoodPairs(1, integers4));

    }

    static long getNumberOfGoodPairs(int n, List<Integer> numbers) {
        List<Integer> p = new ArrayList<>();

        numbers.forEach(nm -> {
            int m = 0;
            m = nm % 200;
            p.add(m);
        });
        System.out.println(p);

        Map<Integer, Long> map = new HashMap<>();

        for (int nm : p) {
            long count = 0;
            if (map.containsKey(nm)) {
                count = map.get(nm);
                map.put(nm, ++count);
            } else {
                map.put(nm, 1L);
            }
        }
        System.out.println("Map is " + map);

        long pairs = 0;

        for (long v : map.values()) {
            pairs += (v - 1) * v / 2;
        }
        return pairs;
    }
}
