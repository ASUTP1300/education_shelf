package uae;


import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Напишите код, который извлекает из строки все
// слова, а затем выводит в порядке убывания частоты
// в этой строке только те, у которых частота >1.
// В строке могут быть слова на английском, знаки пунктуации, пробелы и урлы.
// Урл словом не является и должен быть отброшен.
public class HardString {
    public static void main(String[] args) {
        String test1 =
                "gg UU mama,https://docs.google.com/rus?, . U U U kiss my jok kiss uu gg gg ,,, GH MAMA MAMA MAMA MAMA";

        extractWords(test1);

    }

    public static void extractWords(String str) {
        final String URL_PATTERN = "h.*/.[a-zA-Z]*";
        final String NO_LETTERS_PATTERN = "[^a-zA-Z]";

        Stream.of(str.split(URL_PATTERN))
                .flatMap(s1 -> Stream.of(s1.split(NO_LETTERS_PATTERN)).filter(s2 -> s2.length() > 1))
                .collect(Collectors.groupingBy(s3 -> s3, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .forEach(s4 -> System.out.printf("%s ", s4));
    }
}
