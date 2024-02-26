package edu.spring_wf.collectors_;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Department {

    String name;
    List<Employee> employees;

}