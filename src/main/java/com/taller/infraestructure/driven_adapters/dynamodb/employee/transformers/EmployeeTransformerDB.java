package com.taller.infraestructure.driven_adapters.dynamodb.employee.transformers;

import com.taller.domain.model.employee.Employee;
import com.taller.infraestructure.driven_adapters.dynamodb.employee.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeTransformerDB {
    EmployeeEntity toEntityDB(Employee employee);
    Employee toEntity(EmployeeEntity employeeEntity);
}
