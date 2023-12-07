package static_;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    final static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        Date date = new Date(2023, 12, 5);




        Map<String, Integer> mapOut = new HashMap<>();

        Section section = new Section(mapOut);

        //Кладу в Section's map
        section.putInSectionMap("Тарлан", 38);

        //Кладу в просто map
        mapOut.put("Руслан", 32);

        //Печатаю содержимое map в Section
        System.out.println(section);
    }

    static  class  Section {
        Map<String, Integer> map;

        public Section(Map<String, Integer> map) {
            this.map = map;
        }

        public void putInSectionMap(String name, Integer age) {
            map.put(name, age);
        }

        @Override
        public String toString() {
            return "Section{" +
                    "map=" + map +
                    '}';
        }
    };








    static class TextSection extends Section{

        String text;

        public TextSection(Map<String, Integer> map) {
            super(map);
        }
    }

    static class ListSection extends Section{
        List<String> list;

        public ListSection(Map<String, Integer> map) {
            super(map);
        }
    }
}
