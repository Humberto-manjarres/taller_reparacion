package com.taller.infraestructure.entry_points.reactive_web.employee.transformers;

import com.taller.domain.model.employee.Employee;
import com.taller.infraestructure.entry_points.reactive_web.employee.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeTransformer {
    Employee toEntity(EmployeeDTO employeeDTO);
    EmployeeDTO toDto(Employee employee);
}
