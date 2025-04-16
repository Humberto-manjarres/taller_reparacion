package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItem;
import lombok.*;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class EmployeeItem extends RepairServiceItem {
    private String identification;
    private String name;
    private String specialty;
}
