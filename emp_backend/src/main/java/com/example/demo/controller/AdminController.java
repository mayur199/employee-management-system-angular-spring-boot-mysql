package com.example.demo.controller;

import com.example.demo.model.AdminModel;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AdminController handles HTTP requests for admin-related operations.
 * It provides an endpoint to retrieve all admin records from the database.
 */
@RestController
@RequestMapping("/api/v1/")
public class AdminController {


    @Autowired
    private AdminRepository repo;


    /**
     * Retrieves all admin records from the database.
     *
     * @return a list of AdminModel objects representing all admins.
     */
    @GetMapping("/admin")
    public List<AdminModel> getAllAdmins() {
        return repo.findAll();
    }
}
