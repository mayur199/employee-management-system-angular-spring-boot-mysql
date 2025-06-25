package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * EmployeeController handles HTTP requests for employee-related operations. It
 * provides endpoints to create, read, update, and delete employee records.
 */
@RestController
@RequestMapping("/api/v1/")
@SuppressWarnings("")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    private final EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employee records from the database.
     *
     * @return a list of Employee objects representing all employees.
     */
    @CrossOrigin(origins = {"http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
            "http://localhost:4200"})
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    /**
     * Creates a new employee record in the database.
     *
     * @param employee the Employee object to be created.
     * @return the created Employee object.
     */
    @CrossOrigin(origins = {"http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
            "http://localhost:4200"})
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto dto) {
        logger.info("Creating new employee: " + dto);
        //return employeeRepository.save(employee);
        return employeeService.saveEmployee(dto);
    }

    /**
     * Retrieves an employee record by its ID.
     *
     * @param id the ID of the employee to be retrieved.
     * @return the Employee object with the specified ID.
     * @throws ResourceNotFoundException if the employee with the specified ID does
     *                                   not exist.
     */
    @CrossOrigin(origins = {"http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
            "http://localhost:4200"})
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getByID(@PathVariable Long id) {
        logger.info("Fetching employee with id: " + id);

        EmployeeDto employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * Updates an existing employee record by its ID.
     *
     * @param id              the ID of the employee to be updated.
     * @param employeeDetails the Employee object containing updated details.
     * @return the updated Employee object.
     * @throws ResourceNotFoundException if the employee with the specified ID does
     *                                   not exist.
     */
    @CrossOrigin(origins = {"http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
            "http://localhost:4200"})
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeByID(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        logger.info("Updating employee with id: " + id + " with details: " + employeeDetails);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));

        employee.setFname(employeeDetails.getFname());
        employee.setLname(employeeDetails.getLname());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        employee.setSalary(employeeDetails.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * Deletes an employee record by its ID.
     *
     * @param id the ID of the employee to be deleted.
     * @return a response entity containing a map with a success message.
     * @throws ResourceNotFoundException if the employee with the specified ID does
     *                                   not exist.
     */
    @CrossOrigin(origins = {"http://employee-management-frontend-app.s3-website.ap-south-1.amazonaws.com",
            "http://localhost:4200"})
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        logger.info("Deleting employee with id: " + id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        logger.info("Employee with id: " + id + " deleted successfully");
        logger.info("Response: " + response);
        return ResponseEntity.ok(response);

    }

}