package stepic;

import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
//        int[] tests = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155};
//
//        IntStream.range(4, tests.length).forEach(n ->
//        {
//            if (calculateFibonacci(n) != tests[n - 1]) {
//                throw new RuntimeException("Wrong answer " + n + "\nSorry, but " + tests[n - 1] + " != " + calculateFibonacci(n));
//            }
//        });

//        calculateFibonacci(93);

        System.out.println(4660046610375530309L + 7540113804746346429L + "");
    }

    static long calculateFibonacci(long n) {
        long n1 = 1;
        long n2 = 1;
        long n3 = 2;

        for (long i = 4; i <= n; i++) {
            n1 = n2;
            n2 = n3;
            n3 = n1 + n2;
            System.out.println("Промежуточный результат n = " + n3 + " i = " + i );
        }
        return n3;
    }
}


