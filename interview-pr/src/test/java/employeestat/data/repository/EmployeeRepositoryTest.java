package employeestat.data.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;



class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final Long TEST_COUNT = 4L;
    @Test
    void findCountSalaries() {
        Long count = employeeRepository.findCountSalaries();

        Assertions.assertNotNull(count, "count is null");
        Assertions.assertEquals(TEST_COUNT, count, "count is wrong");
    }
}