package com.taller.infraestructure.driven_adapters.dynamodb.repair;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@DynamoDbBean
public class RepairItem {

    private String pk;
    private String sk;
    private String entityType;
    private String damageId;
    private String employeeId;
    private String repairDate;

    @DynamoDbPartitionKey
    public String getPk() { return pk; }
    public void setPk(String pk) { this.pk = pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }
    public void setSk(String sk) { this.sk = sk; }

    @DynamoDbAttribute("entityType")
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    @DynamoDbAttribute("damageId")
    public String getDamageId() { return damageId; }
    public void setDamageId(String damageId) { this.damageId = damageId; }

    @DynamoDbAttribute("employeeId")
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    @DynamoDbAttribute("repairDate")
    public String getRepairDate() { return repairDate; }
    public void setRepairDate(String repairDate) { this.repairDate = repairDate; }
}
