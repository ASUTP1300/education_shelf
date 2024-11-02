package employeestat.data.repository;

import employeestat.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query (
            value = "select count(id)"+
                    " from employee e join"+
                    "(select e.depno, avg(e.salary) as avg_salary"+
                    "  from employee e"+
                    " group by e.depno) as avg_s on avg_s.depno = e.depno" +
                    " where avg_s.avg_salary < e.salary",
            nativeQuery = true
    )
    Long findCountSalaries();
}


//


/**
 *
 * select count(id)
 *  from employee e join
 * (select e.depno, avg(e.salary) as avg_salary
 *   from employee e
 *  group by e.depno) as avg_s on avg_s.depno = e.depno
 *  where avg_s.avg_salary < e.salary
 *
 *
 *
 *
 *  * "select count(id)"+
 *  * " from employee e join"+
 *  * "(select e.depno, avg(e.salary) as avg_salary"+
 *  * "  from employee e"+
 *  * " group by e.depno) as avg_s on avg_s.depno = e.depno" +
 *  * " where avg_s.avg_salary < e.salary"
 *
 *
 *
 *
 */