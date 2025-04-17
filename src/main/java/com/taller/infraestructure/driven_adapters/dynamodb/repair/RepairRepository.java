package com.taller.infraestructure.driven_adapters.dynamodb.repair;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
@RequiredArgsConstructor
public class RepairRepository {

    private final DynamoDbAsyncTable<RepairItem> table;

    public Mono<Void> save(RepairItem item) {
        return Mono.fromFuture(() -> table.putItem(item)).then();
    }

    public Flux<RepairItem> findRepairEmployee(String employeeId) {
        QueryConditional queryConditional = QueryConditional
                .keyEqualTo(Key.builder().partitionValue(employeeId).build());

        return Flux.from(table.index("EmployeeIndex").query(queryConditional))
                .flatMap(page -> Flux.fromIterable(page.items()));  // <-- aquí extraes los ítems de cada página
    }

}
