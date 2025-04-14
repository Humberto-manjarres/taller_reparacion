package com.taller.infraestructure.driven_adapters.dynamodb.employee;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    private String identification;
    private String name;
    private String specialty;
}
