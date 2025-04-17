package com.taller.infraestructure.driven_adapters.dynamodb.repair;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;

@Repository
@RequiredArgsConstructor
public class RepairRepository {

    private final DynamoDbAsyncTable<RepairItem> table;

    public Mono<Void> save(RepairItem item) {
        return Mono.fromFuture(() -> table.putItem(item)).then();
    }

}
