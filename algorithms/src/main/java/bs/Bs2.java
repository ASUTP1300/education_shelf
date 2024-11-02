package src.main.java.bs;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


//1 61 126 217 2876 6127 39162 98126 712687 1000000000
//100 6127 1 61 200 -10000 1 217 10000 1000000000
public class Bs2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        String init = scanner.nextLine();
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {

        }
//        int[] an = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] ak = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        System.out.println("an: " + Arrays.toString(an));
//        System.out.println("ak: " + Arrays.toString(ak));

//        for (int x : ak) {
//            bSearch(an, x);
//        }
    }

    static void bSearch(int[] a, int x) {

        int l = 0;
        int r = a.length - 1;
        int ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (ok(a, mid, x)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
         if (a[ans] == x ) {
             System.out.println("YES");
         } else {
             System.out.println("NO");
         }
    }

    static boolean ok(int[] a, int mid, int x) {
        return a[mid] <= x;
    }
}
