package ias;

import java.util.Arrays;

public class Prefix {

    //ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5

    static final int[][] RANGES_TEST_1 = {{1, 2}, {3, 4}, {5, 6}};
    static final int[][] RANGES_TEST_2 = {{1, 50}};
    static final int[][] RANGES_TEST_3 = {{1, 1}};



    public static void main(String[] args) {
        System.out.println("Ответ 1 :" +  isCovered(RANGES_TEST_1, 2, 5));
        System.out.println("Ответ 2 :" +  isCovered(RANGES_TEST_2, 1, 50));
        System.out.println("Ответ 3 :" +  isCovered(RANGES_TEST_3, 1, 1));

    }
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];

        for (int[] a : ranges) {
            arr[a[0]] += 1;
            arr[a[1] + 1] -= 1;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        int count = 0;
        System.out.println("Массив " + Arrays.toString(arr));
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }

        return true;
    }

}
