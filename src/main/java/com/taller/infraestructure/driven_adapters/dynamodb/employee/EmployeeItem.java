package com.taller.infraestructure.driven_adapters.dynamodb.employee;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@DynamoDbBean
public class EmployeeItem {

    private String pk;
    private String sk;
    private String entityType;
    private String identification;
    private String name;
    private String specialty;

    @DynamoDbPartitionKey
    public String getPk() { return pk; }
    public void setPk(String pk) { this.pk = pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }
    public void setSk(String sk) { this.sk = sk; }

    @DynamoDbAttribute("entityType")
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    @DynamoDbAttribute("identification")
    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    @DynamoDbAttribute("name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @DynamoDbAttribute("specialty")
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

}
