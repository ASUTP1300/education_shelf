package prefixsum.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hd {
    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{6,9,6}));
    }

    public static int longestWPI(int[] hours) {
        int[] hs = new int[hours.length];

        for (int i = 0; i < hours.length; i++) {
            if(hours[i] > 8) {
                hs[i] += 1;
            } else {
                hs[i] -= 1;
            }
        }

        for (int i = 0; i < hours.length; i++) {
            if (i - 1 >= 0) {
                hs[i] += hs[i - 1];
            }
        }
        Map<Integer, Integer> pos = new HashMap<>();

        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hs[i] > 0) {
                max = Math.max(i + 1, max);
            }

            if (hs[i] <= 0) {
                if (!pos.containsKey(hs[i])) {
                    pos.put(hs[i], i);
                }
                if (pos.containsKey(hs[i] - 1)) {
                    max = Math.max(max, i - pos.get(hs[i] - 1));
                }
            }
        }
        return max;

    }
}
