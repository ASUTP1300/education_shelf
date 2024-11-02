package prefixsum;

import java.util.ArrayList;
import java.util.List;

public class Task2848 {

    public static void main(String[] args) {
        List<List<Integer>> testData = List.of(List.of(3,6),List.of(1,5),List.of(4,7));

        Task2848 task = new Task2848();

        System.out.println(task.numberOfPoints(testData));

    }

    public int numberOfPoints(List<List<Integer>> nums) {
        int[] field = new int[100];
        int[] prefixSum = new int[100];

        for (List<Integer> p : nums) {
            field[p.get(0)] = 1;
            field[p.get(1) + 1] = -1;
        }

        prefixSum[0] = field[0];

        for (int i = 1; i < field.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + field[i];
        }

        int count = 0;
        for (int n : prefixSum) {
            if (n != 0) {
                count++;
            }
        }
        return count;
    }
}

