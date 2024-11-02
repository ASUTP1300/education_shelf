package src.main.java.bs;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Bs7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long w = scanner.nextLong();
        long h = scanner.nextLong();
        long n = scanner.nextLong();

        System.out.println(bestSolution(w, h, n));
    }


    static boolean ok(long mid, long w, long h, long n) {
        if (Math.min((mid / w), (mid / h)) >= n) {
            return true;
        }

        return (mid / w) * (mid / h) >= n;
    }


    static long bestSolution(long w, long h, long n) {
        long l = 0L;
        long r = Long.MAX_VALUE;
        long mid = 0L;
        long ans = 0L;

        while (l <= r) {
            mid = (l + r) / 2;
            if (ok(mid, w, h, n)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


}
