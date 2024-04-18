package ias;

import java.util.Arrays;

public class Prefix2485 {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    public static int pivotInteger(int n) {
        int[] prefixSum = new int[n + 2];
        int[] suffixSum = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] += i + prefixSum[i - 1];
        }

        for (int i = n; i > 0; i--) {
            suffixSum[i] += i + suffixSum[i + 1];
        }

        for (int j = 1; j < suffixSum.length - 1; j++) {
            if (prefixSum[j] == suffixSum[j]) {
                return j;
            }
        }

        System.out.println("Prefix " + Arrays.toString(prefixSum));
        System.out.println("Suffix " + Arrays.toString(suffixSum));

        return -1;
    }
}
