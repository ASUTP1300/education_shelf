package vk;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
 * VK
 * 09.04.24
 */

class Foo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairLowMemory(new int[]{1, 2, 3, 4, 5, 6, 7}, 66)));
    }

    /*
      Задан отсортированный массив целых чисел и еще число K, надо найти пару элементов массива, в сумме дающие заданное число K. Если таких пар несколько, то можно вернуть любую.
    */
    int[] pair(int[] source, int target) {

        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < source.length - 1; i++) {
            nums.add(target - source[i]);
        }

        for (int i = 0; i < source.length - 1; i++) {
            if (nums.contains(source[i])) {
                return new int[]{target - source[i], source[i]};
            }
        }
        return null;
    }

    //
    //    [1, 2, 3, 4, 5, 6, 7] target = 6
    //
    //            1) 6 -1 = 5

    static int[] pairLowMemory(int[] source, int target) {

        int l = 0;
        int r = source.length - 1;

        int sum = 0;

        while (r > l) {
            sum = source[l] + source[r];

            if (sum == target) {
                return new int[]{source[l], source[r]};
            }

            if (sum > target) {
                r--;
            } else {
                l++;
            }

        }
        return null;
    }

}