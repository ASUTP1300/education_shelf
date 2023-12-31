package stepic;

public class Fibonacci {
    public static void main(String[] args) {

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


