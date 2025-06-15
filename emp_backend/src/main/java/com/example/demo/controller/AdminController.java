package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminModel;
import com.example.demo.repository.AdminRepository;

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
