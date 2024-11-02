package src.main.java.bs;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//10 1 10 3 4

public class Bs5 {
    public static void main(String[] args){
//        System.out.println("Hello World!");


        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(Arrays.toString(a));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int[] an = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            counter(an[0], an[1], a);
        }

    }

    static void counter(int l, int r, int[] a) {
        Arrays.sort(a);
        int L = bSearchLow(a, l);
        int R = bSearchHigh(a, r);

        if (a[L] >= l && a[R] <= r) {
            System.out.print(R - L + 1 + " ");
        } else  {
            System.out.print(0 + " ");
        }
    }


    static int bSearchLow(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        int mid = 0;
        int ans = 0;

        while (l <= r) {
            mid = (r + l) / 2;
            if (ok1(a, mid, x)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    static int bSearchHigh(int[] a, int x){
        int l = 0;
        int r = a.length - 1;
        int mid = 0;
        int ans = 0;

        while (l <= r) {
            mid = (r + l) / 2;
            if (ok2(a, mid, x)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = r - 1;
            }
        }
        return ans;
    }

    static boolean ok1(int[] a, int mid, int x) {
        return a[mid] >= x;
    }

    static boolean ok2(int[] a, int mid, int x) {
        return a[mid] <= x;
    }

}