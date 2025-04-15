package com.taller.domain.model.repair;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Repair {
    private String damageId;
    private String employeeId;
    private String repairDate;
}
