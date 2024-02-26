package tnkff.darts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            double r1 = readAndCalculateR(reader);
            double r2 = readAndCalculateR(reader);
            double r3 = readAndCalculateR(reader);

            List<Double> lens = List.of(r1, r2, r3);

            int res = lens.stream()
                    .mapToInt(r -> {
                        if (r <= 0.1) {
                            return 3;
                        } else if (r <= 0.8) {
                            return 2;
                        } else if (r <= 1) {
                            return 1;
                        }
                        return 0;
                    }).sum();

            System.out.println(res);
        }
    }

    private static double readAndCalculateR(BufferedReader reader) throws IOException {
        return Math.sqrt(Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::valueOf).map(d -> Math.pow(d, 2.0)).sum());
    }
}