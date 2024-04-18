package interview;

import java.util.stream.IntStream;

public class JavaCore2 {



    public static void main(String[] args) {
        //Что напечатает..
        test1();

        //Что напечатает..
//        System.out.println(test2(0));
    }

    static void test1() {
        System.out.println(IntStream.range(0, 10).peek(System.out::println).sum());
    }


    static void test2(int n) {
//       int r = IntStream.rangeClosed(0, 5).map(i -> n++).sum();
//       System.out.println(r);
    }

}
