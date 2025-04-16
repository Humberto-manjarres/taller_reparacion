package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter implements EmployeeGateway {

    private final RepairServiceItemRepository repository;

    @Override
    public Mono<Employee> addEmployee(Employee employee) {

        EmployeeItem employeeItem = EmployeeItem.builder()
                .pk("EMPLOYEE#" + employee.getIdentification())
                .sk("PROFILE") //indica que estamos guardando el perfil del empleado
                .entityType("Employee")
                .identification(employee.getIdentification())
                .name(employee.getName())
                .specialty(employee.getSpecialty())
                .build();

        return repository.save(employeeItem).thenReturn(employee);
    }

}
