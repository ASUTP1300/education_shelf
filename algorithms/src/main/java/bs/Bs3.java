package src.main.java.bs;//package src.main.java.bs;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Bs3 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        String init = scanner.nextLine();

        int[] an = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ak = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for (int x : ak) {
            System.out.println(bSearch(an, x));
        }
    }

    static int bSearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        int ans = 0;
        int mid = 0;

        while (l <= r) {
            mid = (r + l) / 2;
            if (ok(a, mid, x)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid  - 1;
            }
        }
        return a[0] > x ? 0 : ans + 1;
    }

    static boolean ok(int[] a, int mid, int x) {
        return a[mid] <= x;
    }
}
