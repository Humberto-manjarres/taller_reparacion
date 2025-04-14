package com.taller.infraestructure.driven_adapters.dynamodb.mapper;

import com.taller.infraestructure.driven_adapters.dynamodb.employee.EmployeeEntity;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

@Component
public class EmployeeMapper implements DynamoDbEntityMapper<EmployeeEntity>{
    @Override
    public Map<String, AttributeValue> toMap(EmployeeEntity entity) {
        return Map.of(
                "identification", AttributeValue.builder().s(entity.getIdentification()).build(),
                "name", AttributeValue.builder().s(entity.getName()).build(),
                "specialty", AttributeValue.builder().s(entity.getSpecialty()).build()
        );
    }

    @Override
    public EmployeeEntity toEntity(Map<String, AttributeValue> item) {
        return EmployeeEntity.builder()
                .identification(item.get("identification").s())
                .name(item.get("name").s())
                .specialty(item.get("specialty").s())
                .build();
    }

}
