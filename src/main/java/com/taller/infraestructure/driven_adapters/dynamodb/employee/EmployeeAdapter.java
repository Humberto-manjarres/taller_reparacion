package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.EmployeeRepairsResponse;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter implements EmployeeGateway {

    private final EmployeeRepository repository;

    @Override
    public Mono<Employee> addEmployee(Employee employee) {

        EmployeeItem employeeItem = new EmployeeItem();
        employeeItem.setPk("EMPLOYEE#" + employee.getIdentification());
        employeeItem.setSk("PROFILE");
        employeeItem.setEntityType("Employee");
        employeeItem.setIdentification(employee.getIdentification());
        employeeItem.setName(employee.getName());
        employeeItem.setSpecialty(employee.getSpecialty());

        System.out.println("Saving: " + employeeItem);

        return repository.save(employeeItem).thenReturn(employee);

    }

    @Override
    public Mono<EmployeeRepairsResponse> findByEmployeeId(String employeeId) {
        return null;
    }

}
