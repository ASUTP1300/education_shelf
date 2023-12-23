package map_;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Polukhin {

    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.comparing(s -> s.chars().sum());

        Map<String, String> footNotes = new TreeMap<>(comparator);

        footNotes.put("1000", "Тест");
        footNotes.put("11", "Тест2");
        footNotes.put("999" +
                "", "Тест3");

        footNotes.keySet().forEach(System.out::println);
    }
}
