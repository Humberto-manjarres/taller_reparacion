package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.employee.transformers.EmployeeTransformerDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter implements EmployeeGateway {

    private final EmployeeRepository repository;
    private final EmployeeTransformerDB transformerDB;

    @Override
    public Mono<Employee> addEmployee(Employee employee) {
        EmployeeEntity entity = transformerDB.toEntityDB(employee);
        return repository.save(entity)
                .map(transformerDB::toEntity);
    }
}
