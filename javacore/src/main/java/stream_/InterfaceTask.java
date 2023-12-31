package stream_;

import java.util.function.Function;

public class InterfaceTask {

    interface I {
        void print();
    }

    private I i = this::create;

    public void test() {
        i.print();
    }

    public I create() {
        return () -> {
            System.out.println("Hello!");
        };
    }

}

class Test {

    static Function<Integer, Integer> function = multi2();

    public static void main(String[] args) {
        InterfaceTask interfaceTask = new InterfaceTask();
        interfaceTask.test();

        System.out.println(function.apply(2));
    }


    static Function<Integer, Integer> multi2(){
        return n -> n * 2;
    }
}
