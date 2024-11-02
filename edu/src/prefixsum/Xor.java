package prefixsum;

import java.util.Arrays;

public class Xor {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(getMaximumXor(new int[] {0,1,1,3}, 2)));
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] prefixXor = new int[nums.length];

        prefixXor[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixXor[i] = nums[i] ^ prefixXor[i - 1];
        }

        int maxK = (1 << maximumBit) - 1;
        int[] ans = new int[nums.length];

        for (int j = prefixXor.length - 1; j >= 0; j--) {
            ans[prefixXor.length - 1 - j] = prefixXor[j] ^ maxK;
        }
        return ans;
    }
}
