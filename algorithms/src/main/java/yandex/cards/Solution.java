package yandex.cards;

import org.springframework.util.Assert;

import java.io.FileNotFoundException;
import java.util.List;

public class Solution {

    static int counter = 0;
    static int K_TEST_1 = 3;
    static int K_TEST_2 = 5;
    static int K_TEST_3 = 4;
    static int K_TEST_4 = 2;

    static List<Long> CARDS_TEST_1 = List.of(5L, 8L, 2L, 1L, 3L, 4L, 11L);
    static List<Long> CARDS_TEST_2 = List.of(1L, 2L, 3L, 4L, 5L);
    static List<Long> CARDS_TEST_3 = List.of(1L, 1L, 9L, 2L, 2L, 2L, 6L);
    static List<Long> CARDS_TEST_4 = List.of(1L, 1L, 9L, 2L, 2L, 2L, 6L);

    static int ANSWER_TEST_1 = 24;
    static int ANSWER_TEST_2 = 15;
    static int ANSWER_TEST_3 = 17;


    public static void main(String[] args) throws FileNotFoundException {


        Assert.isTrue(getCardCount(CARDS_TEST_1.size(), K_TEST_1, CARDS_TEST_1) == ANSWER_TEST_1);
        System.out.println("Счетчик сложности  {5L, 8L, 2L, 1L, 3L, 4L, 11L} " + counter);

        Assert.isTrue(getCardCount(CARDS_TEST_2.size(), K_TEST_2, CARDS_TEST_2) == ANSWER_TEST_2);
        System.out.println("Счетчик сложности  {1L, 2L, 3L, 4L, 5L} " + counter);

        Assert.isTrue(getCardCount(CARDS_TEST_3.size(), K_TEST_3, CARDS_TEST_3) == ANSWER_TEST_3);
        System.out.println("Счетчик сложности  {1L, 1L, 9L, 2L, 2L, 2L, 6L} " + counter);


        getCardCount(CARDS_TEST_4.size(), K_TEST_4, CARDS_TEST_4);
        System.out.println("Счетчик сложности  2 {1L, 1L, 9L, 2L, 2L, 2L, 6L} " + counter);
    }

    private static long getCardCount(int n, int k, List<Long> cards) {
        counter = 0;
        if (k == n) {
            return cards.stream().mapToLong(Long::longValue).sum();
        }

        int max = 0;
        int sum = 0;
        int i = 0;

        while (i <= k) {
            for (int j = k - 1 - i; j >= 0; j--) {
                sum += cards.get(j);
                counter++;
            }
            for (int p = cards.size() - i; p < cards.size(); p++) {
                sum += cards.get(p);
                counter++;
            }
            max = Math.max(sum, max);
            sum = 0;
            i++;
        }

        return max;
    }
}
