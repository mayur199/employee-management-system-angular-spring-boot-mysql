package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFname("John");
        employee.setLname("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment("IT");
        employee.setDesignation("Developer");
        employee.setJoiningDate(java.time.LocalDate.now());
        employee.setSalary(50000);
    }

    @Test
    void testGetAllEmployees() throws Exception {
        List<Employee> employees = Arrays.asList(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fname").value("John"));
    }

    @Test
    void testCreateEmployee() throws Exception {
        Mockito.when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname").value("John"));
    }

    @Test
    void testGetByID() throws Exception {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(get("/api/v1/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    void testGetByID_NotFound() throws Exception {
        Mockito.when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/employees/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateEmployeeByID() throws Exception {
        Employee updated = new Employee();
        updated.setFname("Jane");
        updated.setLname("Smith");
        updated.setEmail("jane.smith@example.com");
        updated.setDepartment("HR");
        updated.setDesignation("Manager");
        employee.setJoiningDate(java.time.LocalDate.now());
        updated.setSalary(60000);

        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(any(Employee.class))).thenReturn(updated);

        mockMvc.perform(put("/api/v1/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname").value("Jane"));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(delete("/api/v1/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Deleted").value(true));
    }

    @Test
    void testCreateEmployee_MissingFields() throws Exception {
        Employee incompleteEmployee = new Employee();
        incompleteEmployee.setFname("John");

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(incompleteEmployee)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateNonExistentEmployee() throws Exception {
        Employee updated = new Employee();
        updated.setFname("Jane");
        updated.setLname("Smith");
        updated.setEmail("jane.smith@example.com");
        updated.setDepartment("HR");
        updated.setDesignation("Manager");
        employee.setJoiningDate(java.time.LocalDate.now());
        updated.setSalary(60000);

        Mockito.when(employeeRepository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/v1/employees/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteNonExistentEmployee() throws Exception {
        Mockito.when(employeeRepository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/v1/employees/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetAllEmployees_EmptyDatabase() throws Exception {
        Mockito.when(employeeRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}