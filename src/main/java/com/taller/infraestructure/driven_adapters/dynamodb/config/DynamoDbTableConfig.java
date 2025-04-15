package com.taller.infraestructure.driven_adapters.dynamodb.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.*;

@Component
@RequiredArgsConstructor
public class DynamoDbTableConfig {

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public Mono<Void> createRepairServiceTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("RepairServiceTable")
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("pk")
                                .attributeType(ScalarAttributeType.S)
                                .build(),
                        AttributeDefinition.builder()
                                .attributeName("sk")
                                .attributeType(ScalarAttributeType.S)
                                .build()
                )
                .keySchema(
                        KeySchemaElement.builder()
                                .attributeName("pk")
                                .keyType(KeyType.HASH)
                                .build(),
                        KeySchemaElement.builder()
                                .attributeName("sk")
                                .keyType(KeyType.RANGE)
                                .build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder()
                                .readCapacityUnits(5L)
                                .writeCapacityUnits(5L)
                                .build()
                )
                .build();

        return Mono.fromFuture(() -> dynamoDbAsyncClient.createTable(request)).then();
    }
}
