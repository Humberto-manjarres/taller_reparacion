package com.taller.infraestructure.driven_adapters.dynamodb.employee;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final DynamoDbAsyncTable<EmployeeItem> table;

    public Mono<Void> save(EmployeeItem item) {
        return Mono.fromFuture(() -> table.putItem(item)).then();
    }

}
