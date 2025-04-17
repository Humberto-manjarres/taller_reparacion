package com.taller.domain.usecase.employee;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.EmployeeRepairsResponse;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmployeeUseCase {

    private final EmployeeGateway employeeGateway;

    public Mono<Employee> addEmployee(Employee employee){
        return employeeGateway.addEmployee(employee);
    }

    public Mono<EmployeeRepairsResponse> findByEmployeeId(String damageId) {
        return employeeGateway.findByEmployeeId(damageId);
    }
}
