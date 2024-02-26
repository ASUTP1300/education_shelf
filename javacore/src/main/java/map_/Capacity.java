package map_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Capacity {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>() {
            {
                put("First", 1);
            }

            {
                put("Second", 2);
            }
        };


        String exm = "()))";

       Map<String, Long> map2 = Arrays.stream(exm.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       int res = (int) (map2.get(")") - map2.get("("));

       res = res < 0 ? -1 * res : res;


        List<String> words = List.of("bats", "act", "tabs", "cat", "in");






        Comparator<String> comparator = (s1, s2) -> {
            char[] a1 = s1.toCharArray();
            char[] a2 = s2.toCharArray();

            Arrays.sort(a1);
            Arrays.sort(a2);

            return Arrays.equals(a1, a2) ? 0 : 1;
        };

        System.out.println(comparator.compare(words.get(0), words.get(3)));




        Map<String, Integer> map1 = new TreeMap<>(comparator);


        words.forEach(w -> {
            if (map1.containsKey(w)) {
                int v = map1.get(w);
                map1.put(w, ++v);
            } else  {
                map1.put(w, 1);
            }
        });

        System.out.println(map1);



//        Map<String, Long> map3 = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(s ->
//            { char[] a = s.toCharArray();
//              Arrays.sort(a);
//              return a;
//            }, Collectors.counting()
//        )));

//        System.out.println(map3);
        System.out.println(map1.containsKey("bats"));

        List<String> sentences = List.of("cat the bats");
        List<Long> res2 = sentences.stream()
                .map(sn -> Arrays.stream(sn.split(" ")).peek(System.out::println).map(ss -> map1.getOrDefault(ss, 0)).mapToLong(sss -> sss).peek(System.out::println).sum())
                .toList();

        System.out.println(res2);

    }

    class Word {
        private final String body;

        public Word(String body) {
            this.body = body;
        }

        public String getBody() {
            return body;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return body.equals(word.body);
        }

        @Override
        public int hashCode() {
            return Objects.hash(body);
        }
    }
}
