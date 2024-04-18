package tnkff.road;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Solution {
    
    int test;

    public void setTest(int test) {
        this.test = test;
    }

    private static long getNumberOfGoodPairs(int n, List<Integer> numbers) {
        // your code goes here
        return 0;
    }




    public static void main(String[] args) throws IOException {

        int[] a = {203, 404, 204, 200, 403};

        for (int n : a) {
            System.out.println(n % 200);
        }


    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().strip().split(" "))
                .stream()
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
    }


    private static double area(int x1, int x2) {
        return x1 == x2 ? 1.0 * 1 : 0.5 * Math.abs(x2 - x1);
    }

    private static void test(Consumer<Integer> consumer, String s) {

    }

}