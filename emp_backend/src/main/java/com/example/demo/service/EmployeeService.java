package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public EmployeeDto saveEmployee(EmployeeDto dto) {
        // You can use employeeMapper for DTO/entity conversion if needed
        Employee entity = employeeMapper.toEntity(dto);
        Employee e = employeeRepository.save(entity);
        log.info("Employee saved with ID: {}", e.getStatus());

        EmployeeDto dtoReturn = employeeMapper.toDto(e);
        log.info("Employee DTO returned: {}", dtoReturn.getStatus());
        return dtoReturn;
    }

    public EmployeeDto getEmployeeById(Long id) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + "does not exists"));

        log.info("Employee saved with ID: {}", e.getStatus());

        EmployeeDto dtoReturn = employeeMapper.toDto(e);
        log.info("Employee DTO returned: {}", dtoReturn.getStatus());
        return dtoReturn;    }
}