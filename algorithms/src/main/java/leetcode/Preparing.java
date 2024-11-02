package src.main.java.leetcode;

import java.util.*;
import java.util.function.BiFunction;

import static java.util.Arrays.*;

public class Preparing {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(filter(new int[]{11, 11, 11, 201}, new int[]{10, 150, 200, 601})));
    }

    // 11, 12, 14, 200
    // 10, 150, 200, 601

    static int[] filter(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        int[] res = new int[a.length];
        int k = 0;

        while (i < a.length) {

            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            while (j < b.length) {

                if (a[i] == b[j]) {
                    i++;
                    break;
                }

                if (a[i] < b[j]) {
                    res[k++] = a[i];
                    i++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                  if (nums[j] == target - nums[i]) {
                      return new int[] {i, j};
                  }
            }
        }
        return null;
    }
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
}
