package src.main.java.bs;

import java.util.Arrays;
import java.util.Scanner;

public class Bs8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        findVerevka(a, k);
    }

    static double findVerevka(int[] a, int k) {
        double l = 0;
        double r = 1E12;

        double mid = 0;
        double ans = 0;

        for (int i = 0; i < 10_000; i++) {
            mid = (l + r) / 2;

            if (ok(a, mid, k)) {
                ans = mid;
                l = mid;
            } else  {
                r = mid;
            }
        }
        System.out.print(ans);
        return l;
    }

    static boolean ok(int[] a, Double mid, int k) {
        int r = 0;
        for (int item : a) {
            r += (int) (item/mid);
        }

        return r >= k;
    }
}
