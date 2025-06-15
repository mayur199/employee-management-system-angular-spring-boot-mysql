package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Admin model.
 */
@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminID;

    @Column(name = "adminName")
    private String adminName;

    @Column(name = "adminPassword")
    private String adminPassword;


}
