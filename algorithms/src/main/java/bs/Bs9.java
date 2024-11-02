package src.main.java.bs;

import java.util.Scanner;

public class Bs9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        simpleTask(n, x, y);
    }

    static void simpleTask(long n, long x, long y) {
        long l = 0;
        long r = Long.MAX_VALUE;

        long ans = 0;
        long mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            if (ok(n, x, y, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        if (n == 1) {
            System.out.println(Math.min(x, y));
        } else {
            System.out.println(ans + Math.min(x, y));
        }
    }

    static boolean ok(long n, long x, long y, long mid) {
        return (mid / x) + (mid /y) >= n - 1;
    }


}
