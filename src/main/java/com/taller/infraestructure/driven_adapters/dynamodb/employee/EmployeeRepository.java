package com.taller.infraestructure.driven_adapters.dynamodb.employee;


import com.taller.infraestructure.driven_adapters.dynamodb.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final DynamoDbAsyncClient dynamoDbAsyncClient;
    private final EmployeeMapper mapper;
    private final String tableName = "employee";

    public Mono<EmployeeEntity> save(EmployeeEntity entity) {
        Map<String, AttributeValue> item = mapper.toMap(entity);
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();
        return Mono.fromFuture(dynamoDbAsyncClient.putItem(request))
                .thenReturn(entity);
    }


}
