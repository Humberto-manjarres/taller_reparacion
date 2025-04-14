package com.taller.application;

import com.taller.infraestructure.driven_adapters.dynamodb.employee.transformers.EmployeeTransformerDB;
import com.taller.infraestructure.entry_points.reactive_web.employee.transformers.EmployeeTransformer;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransformerConfig {

    @Bean
    public EmployeeTransformer employeeTransformer() {
        return Mappers.getMapper(
                EmployeeTransformer.class);
    }

    @Bean
    public EmployeeTransformerDB employeeTransformerDB() {
        return Mappers.getMapper(
                EmployeeTransformerDB.class);
    }
}
