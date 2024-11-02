package prefixsum.hw;

public class SumAllOddLengthSubarrays {
    public static void main(String[] args) {
        System.out.println("2 xor 6 " + (8 | 1| 2) * 4);

        int[] arr = arr = new int[]{1,4,2,5,3};

        System.out.println(pivotInteger(8));
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int[] ps = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ps[i] += arr[i];
            if (i - 1 >= 0) {
                ps[i] += ps[i - 1];
            }
        }

        int res = 0;

        for (int j = 0; j < ps.length; j++) {
            for (int k = j; k < ps.length; k++) {
                if ((k - j + 1) % 2 != 0) {
                    res += ps[k];
                    if (j - 1 >= 0) {
                        res -= ps[j - 1];
                    }
                }
            }
        }
        return res;
    }

    public static int pivotInteger(int n) {
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
        }

        int[] ps = new int[n];
        int[] ss = new int[n];

        for (int j = 0; j < ps.length; j++) {
            ps[j] += ar[j];
            if (j - 1 >= 0) {
                ps[j] += ps[j - 1];
            }
        }

        for (int k = ss.length - 1; k >= 0; k--) {
            ss[k] += ar[k];
            if (k + 1 <= ss.length - 1) {
                ss[k] += ss[k + 1];
            }

            if (ss[k] == ps[k]) {
                return ar[k];
            }
        }
        return -1;
    }
}
