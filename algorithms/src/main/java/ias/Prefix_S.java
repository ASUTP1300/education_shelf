package ias;

import java.util.Arrays;

public class Prefix_S {
    static int[][] SHIFTS =
            {{4, 8, 0}, {4, 4, 0}, {2, 4, 0}, {2, 4, 0}, {6, 7, 1}, {2, 2, 1}, {0, 2, 1}, {8, 8, 0}, {1, 3, 1}};
    static String STR = "xuwdbdqik";


    public static void main(String[] args) {

        System.out.println((char) 99);

        System.out.println("Результат " + shiftingLetters(STR, SHIFTS));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int[] pr = new int[s.length() + 1];

        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] > 0) {
                pr[shifts[i][0]] += 1;
                pr[shifts[i][1] + 1] -= 1;
            } else {
                pr[shifts[i][0]] -= 1;
                pr[shifts[i][1] + 1] += 1;
            }
        }
        System.out.println("До суммы " + Arrays.toString(pr));

        for (int j = 1; j < pr.length; j++) {
            pr[j] += pr[j - 1];
        }

        System.out.println("Сумма " + Arrays.toString(pr));
        StringBuilder res = new StringBuilder();

        int b = 0;
        for (int k = 0; k < s.length(); k++) {
            b = (s.charAt(k) - 'a' + pr[k]) % 26 + 'a';

            res.append((char) b);
        }

        return res.toString();
    }
}

