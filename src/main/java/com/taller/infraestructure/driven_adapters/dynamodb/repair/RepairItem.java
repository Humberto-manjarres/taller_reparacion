package com.taller.infraestructure.driven_adapters.dynamodb.repair;

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
public class RepairItem extends RepairServiceItem {
    private String damageId;
    private String employeeId;
    private String repairDate;
}
