package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "status", source = "status", qualifiedByName = "statusToLabel")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "status", source = "status", qualifiedByName = "statusFromLabel")
    Employee toEntity(EmployeeDto employeeDto);


    @Named("statusFromLabel")
    default Status statusFromLabel(String label) {
        return label != null ? Status.fromLabel(label) : null;
    }

    @Named("statusToLabel")
    default String statusToLabel(Status status) {
        return status != null ? status.getLabel() : null;
    }

}