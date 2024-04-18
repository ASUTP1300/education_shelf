package dump;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1, 2, 1, 6, 7}));
        System.out.println(findDuplicate(new int[] {5, 2, 1, 6, 7}));
        System.out.println(findDuplicate(new int[] {5, -101, 1, -101, 7}));
    }

    static int findDuplicate(int[] arr) {
        Set<Integer> nums =  new HashSet<Integer>();
        for (int j : arr) {
            if (nums.contains(j)) {
                return j;
            } else {
                nums.add(j);
            }
        }
        return -1;
    }
}
