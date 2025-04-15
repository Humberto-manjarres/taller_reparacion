package com.taller.infraestructure.entry_points.reactive_web.repair.transformers;

import com.taller.domain.model.repair.Repair;
import com.taller.infraestructure.entry_points.reactive_web.repair.dto.RepairDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RepairTransformer {
    Repair toEntity(RepairDTO RepairDTO);
    RepairDTO toDto(Repair repair);
}
