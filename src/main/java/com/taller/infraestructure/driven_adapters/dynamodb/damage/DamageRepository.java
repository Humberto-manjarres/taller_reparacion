package com.taller.infraestructure.driven_adapters.dynamodb.damage;


import com.taller.domain.model.damage.Damage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
@RequiredArgsConstructor
public class DamageRepository {

    private final DynamoDbAsyncTable<DamageItem> table;

    public Mono<Void> save(DamageItem item) {
        return Mono.fromFuture(() -> table.putItem(item)).then();
    }

    public Flux<Damage> findByDamageId(String damageId) {
        QueryConditional queryConditional = QueryConditional
                .keyEqualTo(Key.builder()
                        .partitionValue("DAMAGE#" + damageId)
                        .sortValue("INFO")  // Aquí pones el valor exacto de sk
                        .build());

        return Flux.from(table.query(r -> r.queryConditional(queryConditional)))
                .flatMap(page -> Flux.fromIterable(page.items()))
                .map(this::toDomain);
    }

    private Damage toDomain(DamageItem item) {
        return new Damage(item.getId(), item.getDescription());
    }

}
