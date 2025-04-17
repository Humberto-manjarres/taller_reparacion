package com.taller.domain.model.employee.gateway;

import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.EmployeeRepairsResponse;
import reactor.core.publisher.Mono;

public interface EmployeeGateway {
    Mono<Employee> addEmployee(Employee employee);
    Mono<EmployeeRepairsResponse> findByEmployeeId(String employeeId);
}
