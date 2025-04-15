package com.taller.domain.model.damage;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Damage {
    private String id;            // Identificador único del daño
    private String description;   // Descripción del daño (ejemplo: "Rayón")
}
