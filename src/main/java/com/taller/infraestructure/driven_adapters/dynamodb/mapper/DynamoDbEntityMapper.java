package com.taller.infraestructure.driven_adapters.dynamodb.mapper;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

public interface DynamoDbEntityMapper<T> {
    Map<String, AttributeValue> toMap(T entity);
    T toEntity(Map<String, AttributeValue> item);
}
