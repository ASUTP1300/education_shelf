package prefixsum;

import java.util.Arrays;

public class ArrayPrefixSum {


    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}

                };

        matrixBlockSum(mat, 1);

    }
    static public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] p = new int[mat.length][mat[0].length];

        p[0][0] = mat[0][0];

        for (int j = 1; j < mat[0].length; j++) {
            p[0][j] = p[0][j - 1] + mat[0][j];
        }

        for (int i = 1; i < mat.length; i++) {
            p[i][0] = p[i - 1][0] + mat[i][0];
        }
//
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
               p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + mat[i][j];
            }
        }

        int[][] ans = new int[mat.length][mat[0].length];



        for (int i = 0; i < p.length; i++) {
            int left_i = Math.max(0, i - k);
            int right_i = Math.min(p.length - 1, i + k);

            for (int j = 0; j < p[0].length; j++) {
                int left_j = Math.max(0, j - k);
                int right_j = Math.min(p.length - 1, j + k);

                ans[i][j] = p[right_i][right_j];
                if (left_i - 1 >= 0)
                    ans[i][j] -= p[left_i - 1][right_j];
                if (left_j - 1 >= 0)
                    ans[i][j] -= p[right_i][left_j - 1];
                if (left_i - 1 >= 0 && left_j - 1 >= 0)
                    ans[i][j] += p[left_i - 1][left_j - 1];
            }
        }

        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
        return ans;
    }
}
