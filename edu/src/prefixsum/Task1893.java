package prefixsum;

public class Task1893 {
    public static void main(String[] args) {
        int[][] ranges = {{2,21},{2,2}};
        int left = 35;
        int right = 42;

        System.out.println(isCovered(ranges, left, right)); // Output: true
    }
    static public boolean isCovered(int[][] ranges, int left, int right) {
        int[] field = new int[52];
        int[] prefixSum = new int[52];

        for (int[] bound : ranges) {
            field[bound[0]] += 1;
            field[bound[1] + 1] -= 1;
        }

        prefixSum[0] = field[0];
        for (int i = 1; i < field.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + field[i];
        }

        for (int i = left; i < right + 1; i++) {
            if (prefixSum[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
