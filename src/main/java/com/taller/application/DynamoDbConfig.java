package com.taller.application;

import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItem;
import com.taller.infraestructure.driven_adapters.dynamodb.damage.DamageItem;
import com.taller.infraestructure.driven_adapters.dynamodb.employee.EmployeeItem;
import com.taller.infraestructure.driven_adapters.dynamodb.repair.RepairItem;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.dynamodb")
public class DynamoDbConfig {

    private String endpoint;
    private String region;
    private String accessKey;
    private String secretKey;

    @Bean
    public DynamoDbAsyncClient dynamoDbAsyncClient() {
        return DynamoDbAsyncClient.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.of(region))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(accessKey, secretKey)
                        )
                )
                .build();
    }

    @Bean
    public DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient(DynamoDbAsyncClient dynamoDbAsyncClient) {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(dynamoDbAsyncClient)
                .build();
    }


    @Bean
    public DynamoDbAsyncTable<DamageItem> damageItemTable(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        return enhancedAsyncClient.table("RepairServiceTable", TableSchema.fromBean(DamageItem.class));
    }

    @Bean
    public DynamoDbAsyncTable<EmployeeItem> employeeItemTable(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        return enhancedAsyncClient.table("RepairServiceTable", TableSchema.fromBean(EmployeeItem.class));
    }

    @Bean
    public DynamoDbAsyncTable<RepairItem> repairItemTable(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        return enhancedAsyncClient.table("RepairServiceTable", TableSchema.fromBean(RepairItem.class));
    }

}
