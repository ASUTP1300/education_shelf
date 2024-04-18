package ias;

import java.util.Arrays;

public class Prefix2389 {
    static int[] TEST_ARR_1 = {1, 4, 2, 5, 3};
    //1, 7,
    static int[] nums = {4, 5, 2, 1};
    static int[] queries = {3, 10, 21};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }


    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] prefix = new int[nums.length + 1];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += nums[i - 1] + prefix[i - 1];
        }

        int m = 0;
        for (int j = 0; j < queries.length; j++) {
            for (int k = 0; k < prefix.length; k++) {
                if (queries[j] >= prefix[k]) {
                    m = k;
                }
            }
            queries[j] = m;
        }

        return queries;
    }
}
