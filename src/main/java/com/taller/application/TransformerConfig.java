package com.taller.application;

import com.taller.infraestructure.entry_points.reactive_web.damage.transformers.DamageTransformer;
import com.taller.infraestructure.entry_points.reactive_web.employee.transformers.EmployeeTransformer;
import com.taller.infraestructure.entry_points.reactive_web.repair.transformers.RepairTransformer;
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
    public DamageTransformer damageTransformer() {
        return Mappers.getMapper(
                DamageTransformer.class);
    }

    @Bean
    public RepairTransformer repairTransformer() {
        return Mappers.getMapper(
                RepairTransformer.class);
    }

}
