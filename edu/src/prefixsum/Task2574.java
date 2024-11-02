package prefixsum;

import stress_test.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2574 {


    public static void main(String[] args) {
        List<String> tasks = new ArrayList<String>();

        Task2574 task = new Task2574();
        System.out.println(Arrays.toString(task.leftRightDifference(new int[]{10,4,8,3})));

    }

    public int[] leftRightDifference(int[] nums) {

        if (nums.length == 1) {
            return new int[]{0};
        }

        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];
        int[] res = new int[nums.length];

//        leftSums[1] = nums[0];
//        rightSums[rightSums.length - 2] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            leftSums[i] = nums[i - 1] + leftSums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            rightSums[j] = nums[j + 1] + rightSums[j + 1];
        }
        System.out.println("Left : " + Arrays.toString(leftSums));
        System.out.println("Right : " + Arrays.toString(rightSums));

        for (int k = 0; k < leftSums.length; k++) {
            res[k] = Math.abs(leftSums[k] - rightSums[k]);
        }


        return res;
    }


    static int[] generateArray() {
        int n = 1 + (int) (Math.random() * 999);

        int[] arr = new int[4];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + (int) (Math.random() * 99_000);
        }
        System.out.println("Сгенерирован тестовый массив " + Arrays.toString(arr));
        return arr;
    }

//    static int[] badSolution(int[] nums) {
//        int[] leftSums = new int[nums.length + 1];
//        int[] rightSums = new int[nums.length + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            leftSums[i + 1] = nums[i] + leftSums[i];
//        }
//    }

}
