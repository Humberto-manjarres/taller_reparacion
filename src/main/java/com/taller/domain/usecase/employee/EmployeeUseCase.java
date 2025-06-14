package com.taller.domain.usecase.employee;

import com.google.gson.Gson;
import com.taller.domain.model.employee.Employee;
import com.taller.domain.model.employee.EmployeeRepairsResponse;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.infraestructure.driven_adapters.sqs_event_handler.SqsPublisher;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmployeeUseCase {

    private final EmployeeGateway employeeGateway;

    private final SqsPublisher sqsPublisher;

    public Mono<Employee> addEmployee(Employee employee){
        return employeeGateway.addEmployee(employee).doOnSuccess(emp -> {
            String json = new Gson().toJson(emp);
            sqsPublisher.publishMessage(json);
        });
    }

    public Mono<EmployeeRepairsResponse> findByEmployeeId(String damageId) {
        return employeeGateway.findByEmployeeId(damageId);
    }
}
