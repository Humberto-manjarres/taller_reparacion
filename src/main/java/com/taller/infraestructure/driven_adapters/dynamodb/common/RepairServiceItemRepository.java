package com.taller.infraestructure.driven_adapters.dynamodb.common;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RepairServiceItemRepository {

    private final DynamoDbAsyncClient dynamoDbAsyncClient;
    private final String tableName = "RepairServiceTable";

    public Mono<Void> save(RepairServiceItem item) {
        Map<String, AttributeValue> map = Map.of(
                "pk", AttributeValue.builder().s(item.getPk()).build(),
                "sk", AttributeValue.builder().s(item.getSk()).build(),
                "entityType", AttributeValue.builder().s(item.getEntityType()).build(),
                "data", AttributeValue.builder().s(item.getData()).build()
        );
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(map)
                .build();
        return Mono.fromFuture(dynamoDbAsyncClient.putItem(request)).then();
    }


    public Flux<RepairServiceItem> findByDamageId(String damageId) {
        Map<String, AttributeValue> expressionValues = Map.of(
                ":damageId", AttributeValue.builder().s("DAMAGE#" + damageId).build()
        );

        QueryRequest queryRequest = QueryRequest.builder()
                .tableName(tableName)
                .keyConditionExpression("pk = :damageId")
                .expressionAttributeValues(expressionValues)
                .build();

        return Mono.fromFuture(() -> dynamoDbAsyncClient.query(queryRequest))
                .flatMapMany(response -> Flux.fromIterable(response.items()))
                .map(item -> RepairServiceItem.builder()
                        .pk(item.get("pk").s())
                        .sk(item.get("sk").s())
                        .entityType(item.containsKey("entityType") ? item.get("entityType").s() : null)
                        .data(item.get("data").s())
                        .build()
                );
    }

}
