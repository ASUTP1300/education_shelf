package map_;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TarlanInterview extends Thread  implements Runnable{
    public static void main(String[] args) {
        List<Employee> employees = LongStream.range(0, 100).mapToObj(i -> new Employee("Иван" + i, (i % 2 == 0 ? 1L : 2L) )).toList();

//        Map<Long, List<Employee>> employeeByDepartment = ..

        Thread thread = new Thread(new TarlanInterview());

        thread.start();



    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        System.out.println("XA-XA");
    }

    static class Employee {
        String name;

        Long department;

        public Employee(String name, Long department) {
            this.name = name;
            this.department = department;
        }
    }
}
