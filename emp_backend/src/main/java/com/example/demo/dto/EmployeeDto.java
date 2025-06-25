package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * The type Employee.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private long id;

    private String fname;

    private String lname;

    private String email;

    private long salary;

    private String department;

    private String designation;

    private LocalDate joiningDate;

    private String status;


}
