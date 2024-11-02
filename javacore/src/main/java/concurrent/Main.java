package concurrent;

public class Main {

    private static final Object MONITOR = new Object();
    public static void main(String[] args) {
       new Thread(new Loader()).start();

        new Thread(new Reader()).start();
        Thread th2 = new Thread(new Loader());
    }

    static class Loader implements Runnable {
        @Override
        public void run() {

            synchronized(MONITOR)   {

                System.out.println("загрузка документа");
                try {
                    Thread.sleep(500);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("документ загружен");
                MONITOR.notifyAll();
                System.out.println("Корочка");
                MONITOR.notifyAll();
            }

        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            synchronized(MONITOR)  {
                try {
                    MONITOR.wait(100);
                    System.out.println("чтение документа");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}