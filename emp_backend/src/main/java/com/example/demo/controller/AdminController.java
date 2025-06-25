package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminModel;
import com.example.demo.repository.AdminRepository;

/**
 * AdminController handles HTTP requests for admin-related operations. It
 * provides an endpoint to retrieve all admin records from the database.
 */
@CrossOrigin(origins = { "http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
		"http://localhost:4200" })
@RestController
@RequestMapping("/api/v1/")
public class AdminController {

	private final AdminRepository repo;

	public AdminController(AdminRepository repo) {
		this.repo = repo;
	}

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
