package com.taller.infraestructure.entry_points.reactive_web.damage.transformers;

import com.taller.domain.model.damage.Damage;
import com.taller.infraestructure.entry_points.reactive_web.damage.dto.DamageDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DamageTransformer {
    Damage toEntity(DamageDTO damageDTO);
}
