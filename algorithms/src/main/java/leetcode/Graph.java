package src.main.java.leetcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {


    public static void main(String[] args) throws IOException {
        int[][] matrix = readMatrix(new BufferedReader(new InputStreamReader(System.in)));

//        for (int[] a : matrix) {
//            System.out.println(Arrays.toString(a));
//        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT.TXT"));

        bufferedWriter.write("" + solver(matrix));
        bufferedWriter.flush();

    }

    private static int solver(int[][] graph) {
        int ans = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        String size = reader.readLine();
        int n = Integer.parseInt(size);

        int[][] matrix = new int[n][n];
        String[] lines = null;

        for (int i = 0; i < n; i++) {
            lines = reader.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(lines[j]);
            }
        }
        return matrix;
    }


}
