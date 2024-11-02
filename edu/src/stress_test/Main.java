package stress_test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (TestData data: generateCases(3000)) {
            test(data.arr, data.query);
        }
    }
    public static int[] badSolution(int[] arr, int[][] query) {

        //O(m * n)
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int sum_l_r = 0;
            for (int j = query[i][0]; j < query[i][1] + 1; j++) {
                sum_l_r += arr[j];
            }
            ans[i] = sum_l_r;
        }
        return ans;
    }


    public static int[] bestSolution(int[] arr, int[][] query) {
        //O(n)
        int[] ans = new int[query.length];
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < query.length; i++) {
            int sum_l_r = prefixSum[query[i][1]];
            if (query[i][0] - 1 >= 0) {
                 sum_l_r = prefixSum[query[i][1]] - prefixSum[query[i][0] - 1];
            }
            ans[i] = sum_l_r;
        }
        return ans;
    }


    static void test(int[] arr, int[][] query) {
        if (!Arrays.equals(bestSolution(arr, query), badSolution(arr, query))) {
            System.out.println("Test Failed!");
            System.out.println("arr = " + Arrays.toString(arr));
            System.out.println("query = " + Arrays.toString(query));
            System.out.println("BestSolution = " + Arrays.toString(bestSolution(arr, query)));
            System.out.println("BadSolution = " + Arrays.toString(badSolution(arr, query)));
            throw new RuntimeException("Test Failed!");
        }
    }

    static TestData[] generateCases(int count) {
        TestData[] res = new TestData[count];

        for (int i = 0; i < count; i++) {
            res[i] = new TestData(generateArr(), generateQuery());
        }
        return res;
    }

    static class TestData {
        int[] arr;
        int[][] query;

        public TestData(int[] arr, int[][] query) {
            this.arr = arr;
            this.query = query;
        }
    }


    static int[] generateArr() {
        int n = 30;
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 60) - 30;
        }
        return arr;
    }


    static int[][] generateQuery() {
        int n = 30;
        int m = 100;
        int[][] query = new int[m][2];

        for (int i = 0; i < m; i++) {
            int l = (int) (Math.random() * (n - 1));
            int r = (int) (Math.random() * (n - l -1)) + l;
            query[i][0] = l;
            query[i][1] = r;
        }
        return query;
    }
}
