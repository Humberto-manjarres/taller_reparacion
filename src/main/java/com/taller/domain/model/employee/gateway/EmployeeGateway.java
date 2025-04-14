package com.taller.domain.model.employee.gateway;

import com.taller.domain.model.employee.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeGateway {
    Mono<Employee> addEmployee(Employee employee);
}
