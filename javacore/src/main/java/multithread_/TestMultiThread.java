package multithread_;

public class TestMultiThread {
    private int count = 1;
    public synchronized void doSomething() {
        for (int i = 0; i < 10; i++) {
            System.out.println(count++);
        }
    }

    public static void main(String[] args) {
        TestMultiThread thread = new TestMultiThread();

        Thread a1 = new A(thread);
        Thread a2 = new A(thread);

        a1.start();
        a2.start();


    }


}
class A extends  Thread {
    TestMultiThread demo;

    public A(TestMultiThread thread) {
        demo = thread;
    }

    @Override
    public void run() {
        demo.doSomething();
    }
}