package ias;

import java.util.Arrays;

public class StressTest {
    public static void main(String[] args) {
        test();
    }



    static void test() {
        int n = 30;
        int m = 100;

        int[] arr = new int[30];


        for (int i = 0; i < n - 1; i++) {
            arr[i] = (int) (Math.random() * n) - 15;
        }

        Interval[] queries = new Interval[m];

        for (int j = 0; j < queries.length - 1; j++) {
            int l = (int) (Math.random() * n) - 1;
            int r = l + (int) (Math.random() * (n - l)) - 1;
            queries[j] = new Interval(l, r);
        }
        System.out.println(" Массив: " + Arrays.toString(arr));
        System.out.println(" Интервалы: " + Arrays.toString(queries));

    }

    static int prefixSum(int x1, int x2, int[] arr) {
        int sum = 0;

        for (int i = x1; i < x2; i++) {
            sum += arr[i];
        }
        return sum;
    }
    static class Interval {
        int l;
        int r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }



}
