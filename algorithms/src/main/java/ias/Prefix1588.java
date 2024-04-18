package ias;

import java.util.Arrays;
import java.util.Optional;

public class Prefix1588 {
    static int[] TEST_ARR_1 = {1, 4, 2, 5, 3};
    //1, 7,

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(TEST_ARR_1));
    }

    static public int sumOddLengthSubarrays(int[] arr) {
        int[] prefArr = new int[arr.length];

        prefArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefArr[i] += arr[i] + prefArr[i - 1];
        }
        System.out.println( "Массив pref  " + Arrays.toString(prefArr));

        Optional<String> string =  Optional.empty();
        string.orElseThrow(() -> new IllegalArgumentException("sdsd"));

        int sum = 0;

        for (int j = 0; j < arr.length; j++) {
            for (int k = j; k < arr.length; k++) {
                if ((k - j + 1) % 2 != 0) {
                    if (j == 0) {
                        sum += prefArr[k];
                        System.out.println("prefArr[k] " + prefArr[k]);
                    } else {
                        sum += prefArr[k] - prefArr[j - 1];
                    }
                }
            }
        }
        return sum;
    }
}
