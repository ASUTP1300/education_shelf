package reader_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ContractReader {

    static String FILE_NAME_IN_STRATEGY = "report-strategy.txt";
    static String FILE_NAME_IN_MANAGER = "report-manager.txt";

    static String FILE_NAME_OUT_STRATEGY = "bad-strategy-grps.txt";
    static String FILE_NAME_OUT_MANAGER = "bad-manager-grps.txt";




    public static void main(String[] args) {

        //strategy
        doReport(FILE_NAME_IN_STRATEGY, FILE_NAME_OUT_STRATEGY);


        //manager
//        doReport(FILE_NAME_IN_MANAGER, FILE_NAME_OUT_MANAGER);
    }


    static void doReport(String in, String out) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(out));
            writer.write("ContractId:");
            writer.write("\n");
            writer.write("------------");
            writer.write("\n");
            Objects.requireNonNull(read(in))
                    .map(s -> s.contains("Exception while closing command") ? s.substring(614, 623)
                            : s.substring(448, 457))
                    .filter(s -> Pattern.compile("'(\\d+)'").matcher(s).matches())
                    .distinct()
                    .map(s -> s.substring(1, s.length() - 1))
//                    .sorted()
                    .peek(str -> {
                        try {
                            writer.write(str);
                            writer.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(System.out::println);
            System.out.println("------------");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static Stream<String> read(String file) {
        File file2 = new File(file);

        if (!file2.isFile()) {
            throw new RuntimeException("Нет файла " + file);
        }


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.lines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


