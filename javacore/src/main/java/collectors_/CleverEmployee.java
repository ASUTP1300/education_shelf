package collectors_;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//26.02.24 beeline
public class CleverEmployee {
     static Department dep1 = new Department().setName("HR")
            .setEmployees(
                    List.of(
                            new Employee().setFullName("Employee 11").setSalary(new BigDecimal("1000.30")),
                            new Employee().setFullName("Employee 12").setSalary(new BigDecimal("1500.30")),
                            new Employee().setFullName("Employee 13").setSalary(new BigDecimal("1800.30")),
                            new Employee().setFullName("Employee 14").setSalary(new BigDecimal("1700.30")),
                            new Employee().setFullName("Employee 15").setSalary(new BigDecimal("1900.30"))
                    ));
    static Department dep2 = new Department().setName("Payroll")
            .setEmployees(
                    List.of(
                            new Employee().setFullName("Employee 21").setSalary(new BigDecimal("1000.30")),
                            new Employee().setFullName("Employee 22").setSalary(new BigDecimal("1500.30")),
                            new Employee().setFullName("Employee 23").setSalary(new BigDecimal("1500.30"))
                    ));
    static Department dep3 = new Department().setName("IT")
            .setEmployees(
                    List.of(
                            new Employee().setFullName("Employee 31").setSalary(new BigDecimal("1800")),
                            new Employee().setFullName("Employee 33").setSalary(new BigDecimal("1800")),
                            new Employee().setFullName("Employee 34").setSalary(new BigDecimal("1800"))
                    ));
    static List<Department> departments = List.of(dep1, dep2, dep3);


    public static void main(String[] args) {

        // Получить список всех сотрудников со второй самой высокой зарплатой каждом отделе
        // Необходимо продолжить используя Stream API
        List<Employee> res = departments.stream()
                .collect(Collectors.groupingBy(Department::getName,
                                    Collectors.flatMapping(
                                            d -> distinctEmployees(d.getEmployees().stream())
                                                    .sorted(Comparator.comparing(Employee::getSalary)
                                                    .reversed())
                                                    .limit(2)
                                                    .skip(1), Collectors.toList()
                                    )
                          )
                )
                .values().stream()
                    .filter(l -> !l.isEmpty())
                    .flatMap(Collection::stream)
                    .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();


        System.out.println(res);

    }

    static  Stream<Employee> distinctEmployees(Stream<Employee> employee) {
        return employee
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getSalary))))
                .stream();
    }

}

