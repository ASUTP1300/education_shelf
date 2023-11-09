package yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

public class Partition_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));


        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[0];

        String nums = reader.readLine();
        if (!nums.isEmpty()) {
            a = Arrays.stream(nums.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int x = Integer.parseInt(reader.readLine());

        System.out.println("N: " + n);

        System.out.println("Array: " + Arrays.toString(a));
        System.out.println("X: " + x);

        int p = partition(num -> num < x, a, 0, a.length - 1);
        System.out.println("P: " + p);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(p  + 1 + "\n");
        writer.write(a.length - ( p  + 1) + "");
        writer.flush();
        System.out.println("Array: " + Arrays.toString(a));

        tests();





    }
    //1 9 4 2 3
    static int partition(Predicate<Integer> predicate, int[] a, int l, int r) {
        int p = 0;
        if (a.length == 1) {
            return predicate.test(a[0]) ? 0 : -1;
        }
        while (r > l ) {
            while (predicate.test(a[l]) && l < a.length - 1) {
                l++;
            }
            while (!predicate.test(a[r]) && r > 0) {
                r--;
            }

            swap(l, r, a);
            p = l;
            l++;
            r--;
        }
        return p != 0 ? p : -1;
    }


    static void swap(int l, int r, int[] a) {
        int buf = a[l];
        a[l] = a[r];
        a[r] = buf;
    }

    static void tests() {
        int[] test1 = {1, 9, 4, 2, 3};
        int[] test2 = {};
        int[] test3 = {0};
        int[] test4 = {1, 2, 3, 4, 5};
        int[] test5 = {1, 2, 3, 4, 5};
        int[] test6 = {0};

        int x1 = 3;
        int x2 = 0;
        int x3 = 0;
        int x4 = 6;
        int x5 = 0;
        int x6 = 1;


       if (partition(n -> n < x1, test1, 0, test1.length - 1) != 1) {
           throw new RuntimeException("TEST1");
       }
        if (partition(n -> n < x2, test2, 0, 0) != -1) {
            throw new RuntimeException("TEST2");
        }
        if (partition(n -> n < x3, test3, 0, 0) != -1) {
            throw new RuntimeException("TEST3");
        }
        if (partition(n -> n < x4, test4, 0, test4.length - 1) != 4) {
            throw new RuntimeException("TEST4");
        }
        if (partition(n -> n < x5, test5, 0, test5.length - 1) != -1) {
            throw  new RuntimeException("TEST5");
        }
        if (partition(n -> n < x6, test6, 0, 0) != 0) {
            throw new RuntimeException("TEST6");
        }
    }

}
