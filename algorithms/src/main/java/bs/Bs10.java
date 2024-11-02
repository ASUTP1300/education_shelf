package src.main.java.bs;

import java.lang.reflect.Field;
import java.util.*;

public class Bs10 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 999);
        map.put(2, 999);

        map.merge(1, 1, Integer::sum);
        map.merge(2, 1, Integer::sum);

        System.out.println("-------------------------------- Мапа " + map);

//
//
//        Scanner scanner = new Scanner(System.in);
//
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        Man[] people = new Man[n];
//
//        for (int i = 0; i < n; i++) {
//            people[i] = new Man(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
//        }
//
//        int T = findTime(m, people);
//        System.out.println(T);
//        for (int i = 0; i < people.length; i++) {
////           System.out.println("Помощник  " + i + " надул " + (T / people[i].t) + " шаров");
//            int count = T / people[i].t;
//
//            System.out.print(Math.min(count, m) + " ");
//
//            if (count <= m) {
//                m -= count;
//            } else {
//                m =0;
//            }
//
//        }
    }

    static int findTime(int m, Man[] people) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int ans = 0;
        int mid = 0;

        while (l <= r) {
            mid = (r + l) / 2;

            if (ok(m, mid, people)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
//        System.out.println("Общее время: " + ans + " мин");
        return ans;
    }

    static boolean ok(int m, int mid, Man[] people) {
        int res = 0;

        for (Man man : people) {
            int z = (mid * ((man.t * man.z) + man.y));
            int d = ( man.t * man.t * man.z);

            res += z / d + z % d;
        }
        return mid >= m;
    }

    static class Man {
        int t;
        int z;
        int y;
        public Man(int t, int z, int y) {
            this.t = t;
            this.z = z;
            this.y = y;
        }
    }
}
