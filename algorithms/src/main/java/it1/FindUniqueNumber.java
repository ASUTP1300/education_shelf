package it1;

import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Function;

/*
 * IT1
 * 02.11.23
 *
 * /

/*
 * Найти первый не повторяющийся элемент в массиве целых чисел
 */
public class FindUniqueNumber {
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4, 5};

        System.out.println(findFirstUniqueInt_Onxn(arr));
        System.out.println(findFirstUniqueInt_On(arr));
    }

    public static int findFirstUniqueInt_Onxn(int[] arr) {
        int count = 0;
        for (int k : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (k == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return k;
            }
            count = 0;
        }
        return 0;
    }

    public static int findFirstUniqueInt_On(int[] arr) {
        Map<Integer, Long> nums = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(arr)
                .filter(n -> nums.get(n) == 1)
                .findFirst()
                .orElse(-1);
    }
}