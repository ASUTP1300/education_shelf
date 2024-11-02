package src.main.java.bs;

public class Bs1 {
    public static void main(String[] args) {
        bSearch(new int[] {1, 1, 3, 4, 7, 8}, 6);

    }

    static void bSearch(int[] a, int x) {

        //Шаблон!
        int l = 0;
        int r = a.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r)/2;
            if (ok(a, mid, x)) {
                //Max or Min
                //Если Min сдвигаем правую границу
                ans = mid;
                l = mid + 1;
                //Ecли Max свд
            } else {
                r = mid - 1;
            }
        }
        System.out.println("pos = " + ans);
        System.out.println("value = " + a[ans]);
    }
   static boolean ok(int[] a, int mid, int x) {
        return a[mid] <= x;
    }
}
