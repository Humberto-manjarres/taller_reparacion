package com.taller.application;


import com.taller.domain.model.damage.gateway.DamageGateway;
import com.taller.domain.model.employee.gateway.EmployeeGateway;
import com.taller.domain.model.repair.gateway.RepairGateway;
import com.taller.domain.usecase.damage.DamageUseCase;
import com.taller.domain.usecase.employee.EmployeeUseCase;
import com.taller.domain.usecase.repair.RepairUseCase;
import com.taller.infraestructure.driven_adapters.sqs_event_handler.SqsPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeGateway employeeGateway, SqsPublisher sqsPublisher){
        return new EmployeeUseCase(employeeGateway,sqsPublisher);
    }

    @Bean
    public DamageUseCase damageUseCase(DamageGateway damageGateway){
        return new DamageUseCase(damageGateway);
    }

    @Bean
    public RepairUseCase repairUseCase(RepairGateway repairGateway){
        return new RepairUseCase(repairGateway);
    }

}
