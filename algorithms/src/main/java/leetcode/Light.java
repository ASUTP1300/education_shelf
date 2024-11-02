//package src.main.java.leetcode;

import java.io.*;
import java.util.Arrays;

public class Light {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] res = new int[in[0]];
        int v, u;

        for (int i = 0; i < in[1]; i++) {
            int[] uv = readMatrix(br);
            v = uv[0];
            u = uv[1];

            res[v - 1] += 1;
            res[u - 1] += 1;
        }
//        System.out.println(Arrays.toString(res));


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT.TXT"));

        Arrays.stream(res).forEach( n -> {
            try {
                bufferedWriter.write(n + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bufferedWriter.flush();

    }
    private static int[] readMatrix(BufferedReader reader) throws IOException {

        return Arrays.stream(reader.readLine().split(" ")).peek(System.out::println).mapToInt(Integer::parseInt). toArray();
    }
}
