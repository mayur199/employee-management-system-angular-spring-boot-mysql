package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Employee.
 */
@Entity
@Table(name = "employees_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "f_name")
    private String fname;

    @Column(name = "l_name")
    private String lname;

    @Column(name = "mail")
    private String email;

    @Column(name = "sal")
    private long salary;

    @Column(name = "dep")
    private String department;

    @Column(name = "des")
    private String designation;

    @Column(name = "jd")
    private LocalDate joiningDate;

}
