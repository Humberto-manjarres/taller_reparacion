package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItem;
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

        String jsonData = String.format("{ \"name\": \"%s\", \"specialty\": \"%s\" }",
                employee.getName(),
                employee.getSpecialty());

        RepairServiceItem item = RepairServiceItem.builder()
                .pk("EMPLOYEE#" + employee.getIdentification())
                .sk("PROFILE") //indica que estamos guardando el perfil del empleado
                .entityType("Employee")
                .data(jsonData)
                .build();
        return repository.save(item).thenReturn(employee);
    }

}
