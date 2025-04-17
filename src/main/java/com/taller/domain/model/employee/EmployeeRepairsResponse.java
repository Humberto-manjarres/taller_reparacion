package com.taller.domain.model.employee;

import com.taller.domain.model.repair.Repair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRepairsResponse {
    private String identification;
    private String name;
    private String specialty;
    private List<Repair> repairs;
}
