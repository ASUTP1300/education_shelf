package prefixsum;

import java.util.Arrays;

public class Or {

    public static void main(String[] args) {
        System.out.println("3 >> 2 =" + (3 << 2));
        System.out.println("32 | 3 = " + (32 | 3));
        System.out.println("1 | 8 = " + (1 | 8));
        System.out.println("1 | 2 = " + (1 | 2));
        System.out.println("8 | 1  | 2 ^ 8 = " + (8 | 1 | 2 ));
        System.out.println("2 | 1 =" + (2 | 1));

        maximumOr(new int[] {8,1,2}, 2);
    }
    public static long maximumOr(int[] nums, int k) {
        int[] por = new int[nums.length];
        int[] sor = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            por[i] = nums[i];
            if (i - 1 >= 0) {
                por[i] |= por[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            sor[i] = nums[i];
            if (i  < nums.length - 1) {
                sor[i] =sor[i] | sor[i + 1];
            }
        }
        System.out.println("PREFIX " + Arrays.toString(por));
        System.out.println("SUFIX " + Arrays.toString(sor));

        long max = -1;
        long b = 0;

        for (int j = 0; j < nums.length; j++) {
            b = (long) nums[j] << k;
            System.out.println("до b = " + b);

            if (j - 1 >= 0) {
                b = por[j - 1] | b;
            }
            if (j + 1 < nums.length - 1) {
                b = b | sor[j + 1];
            }
            System.out.println("после b = " + b);
            max = Math.max(max, b);
        }
        return max;
    }
}
