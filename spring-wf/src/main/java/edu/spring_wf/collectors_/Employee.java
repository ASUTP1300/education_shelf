package edu.spring_wf.collectors_;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Employee {

    String fullName;
    BigDecimal salary;

}