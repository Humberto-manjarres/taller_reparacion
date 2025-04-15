package com.taller.infraestructure.entry_points.reactive_web.repair.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepairDTO {
    private String damageId;
    private String employeeId;
    private String repairDate;
}
