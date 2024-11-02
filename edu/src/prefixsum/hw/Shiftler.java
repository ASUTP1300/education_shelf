package prefixsum.hw;

import java.util.Arrays;

public class Shiftler {

    public static void main(String[] args) {
        System.out.println(0 +'^');
        System.out.println(0 + 'a');
        System.out.println(0 + 'z');

        int[][] b = {{4,8,0},{4,4,0},{2,4,0},{2,4,0},{6,7,1},{2,2,1},{0,2,1},{8,8,0},{1,3,1}};
        int[][] a = {{0,1,0},{1,2,1},{0,2,1}};
        shiftingLetters("xuwdbdqik", b);
    }


    public  static String shiftingLetters(String s, int[][] shifts) {
        int[] ps = new int[s.length() + 1];

        for (int i = 0; i < shifts.length; i++) {

            if (shifts[i][2] == 0) {
                ps[shifts[i][0]] += -1;
                ps[shifts[i][1] + 1] += 1;
            } else {
                ps[shifts[i][0]] += 1;
                ps[shifts[i][1] + 1] += -1;
            }
        }

            for (int i = 0; i < ps.length; i++) {
                if (i - 1 >= 0) {
                    ps[i] += ps[i - 1];
                }
            }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char x =  (char) ((s.charAt(i)- 'a' + ps[i]) % 26 + 'a');
            sb.append(x);
        }
        System.out.println(sb);

        return "S";


    }
}
