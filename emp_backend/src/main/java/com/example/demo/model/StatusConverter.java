// File: emp_backend/src/main/java/com/example/demo/model/StatusConverter.java
package com.example.demo.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        return status != null ? status.getLabel() : null;
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        return dbData != null ? Status.fromLabel(dbData) : null;
    }
}