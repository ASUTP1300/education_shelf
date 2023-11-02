package yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MinOnLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

       int[] conditions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       int N = conditions[0];
       int M = conditions[1];

       int[] seq = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

       FileWriter writer = new FileWriter("output.txt");
       for (int i = 0; i < M; i++) {
           String[] nums = reader.readLine().split(" ");
           writer.write(noMin(seq, Integer.parseInt(nums[0]), Integer.parseInt(nums[1])));
           writer.write("\n");
       }
       writer.flush();

    }

    public static String noMin(int[] seq, int l, int r) {
        System.out.println("Sequence: " + Arrays.toString(seq));
        System.out.println("L: " + l);
        System.out.println("R :" + r);


        int min = seq[l];


        for (int i = l; i <= r; i++) {
            if (seq[i] > min) {
                return String.valueOf(seq[i]);
            }
            min = Math.min(min, seq[i]);
        }

        return "NOT_FOUND";
    }
}
