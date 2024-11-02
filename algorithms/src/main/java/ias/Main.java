package src.main.java.ias;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Дан массив нулей и единиц, нужно отсорировать так, что бы вначале шли единицы а затем нули
 *  например:
 *  {1, 0, 0, 0, 1, 1, 0}
 *  должно: [1, 1, 1, 0, 0, 0, 0]
 */
public class Main {

    public static void main(String[] args) {


        Set<Integer> set = new HashSet<Integer>();


        int[] arr = {1, 0, 0, 0, 1, 1, 0};

        System.out.println(Arrays.toString(compact(arr)));
    }

    static int[] compact(int[] a) {
        int[] res = new int[a.length];
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                res[j++] = 1;
            }
        }
        return res;
    }
}
