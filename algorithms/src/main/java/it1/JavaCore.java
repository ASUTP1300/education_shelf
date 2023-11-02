package it1;


public class JavaCore {
    public static void main(String[] args) {

        System.out.println(test1());
        System.out.println(test2());
    }

    //Test finally()
    static int test1() {
        try {
            return 1;
        } finally {
            return 0;
        }
    }

    static int test2() {
        final int[] ar = {1, 2, 3};
        try {
            test2();
            int a  = 3 / 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally has executed");
        }
        return 0;
    }
}
