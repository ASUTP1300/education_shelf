package prefixsum.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDiv2 {

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
    }


    public static int minSubarray(int[] nums, int p) {
        long[] ps = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = nums[i];

            if (i - 1 >= 0) {
                ps[i + 1] += ps[i];
            }
        }

        if (ps[ps.length - 1] % p == 0) {
            return 0;
        }


        Map<Long, Integer> leftBounds = new HashMap<Long, Integer>();

        long leftBound = 0;
        int ans = nums.length;
        for (int r = 1; r < ps.length; r++) {
            System.out.println("ps[r] " + ps[r]);

            leftBound = (ps[r] % p - ps[ps.length - 1] % p + p) % p;
            if (leftBounds.containsKey(leftBound)) {
                ans = Math.min(ans, r - leftBounds.get(leftBound));
            }
            leftBounds.put(ps[r] % p, r);
        }
        if (ans == nums.length) {
            return -1;
        }


        System.out.println(Arrays.toString(ps));
        return ans;
    }



}
