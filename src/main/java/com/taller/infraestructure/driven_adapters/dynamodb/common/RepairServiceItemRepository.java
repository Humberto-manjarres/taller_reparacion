package com.taller.infraestructure.driven_adapters.dynamodb.common;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Repository
@RequiredArgsConstructor
public class RepairServiceItemRepository {

    private final DynamoDbAsyncTable<RepairServiceItem> table;

    public Mono<Void> save(RepairServiceItem item) {
        return Mono.fromFuture(() -> table.putItem(item)).then();
    }

    public Flux<RepairServiceItem> findByDamageId(String damageId) {
        QueryConditional queryConditional = QueryConditional
                .keyEqualTo(Key.builder().partitionValue("DAMAGE#" + damageId).build());

        return Flux.from(table.query(queryConditional))
                .flatMap(page -> Flux.fromIterable(page.items()));
    }

}
