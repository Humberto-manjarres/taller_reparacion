package com.taller.application;


import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.domain.usecase.employee.EmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeGateway employeeGateway){
        return new EmployeeUseCase(employeeGateway);
    }

}
