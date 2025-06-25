package com.example.demo.model;


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
