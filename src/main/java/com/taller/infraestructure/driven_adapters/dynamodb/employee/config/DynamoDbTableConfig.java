package com.taller.infraestructure.driven_adapters.dynamodb.employee.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@Component
@RequiredArgsConstructor
public class DynamoDbTableConfig {

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public Mono<Void> createTable(String tableName) {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName(tableName)
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("identification")
                                .attributeType(ScalarAttributeType.S)
                                .build()
                )
                .keySchema(
                        KeySchemaElement.builder()
                                .attributeName("identification")
                                .keyType(KeyType.HASH)
                                .build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder()
                                .readCapacityUnits(5L)
                                .writeCapacityUnits(5L)
                                .build()
                )
                .build();

        return Mono.fromFuture(() -> dynamoDbAsyncClient.createTable(request))
                .then();
    }
}
