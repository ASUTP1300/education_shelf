package employeestat.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String sex;

    private Long department;

    private String post;

    private Long salary;

    public Employee(String name, LocalDate birthDate, String sex, Long department, String post, Long salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.department = department;
        this.post = post;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public Long getDepartment() {
        return department;
    }

    public String getPost() {
        return post;
    }

    public Long getSalary() {
        return salary;
    }

}
