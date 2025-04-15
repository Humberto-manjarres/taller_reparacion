package com.taller.infraestructure.entry_points.reactive_web.damage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DamageDTO {
    private String id;
    private String description;
}
