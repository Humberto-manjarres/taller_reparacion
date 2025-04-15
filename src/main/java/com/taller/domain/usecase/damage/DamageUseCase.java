package com.taller.domain.usecase.damage;


import com.taller.domain.model.damage.Damage;
import com.taller.domain.model.damage.gateway.DamageGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItem;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DamageUseCase {
    private final DamageGateway damageGateway;

    public Mono<Damage> addDamage(Damage damage){
        return damageGateway.addDamage(damage);
    }

    public Flux<RepairServiceItem> findByDamageId(String damageId) {
        return damageGateway.findByDamageId(damageId);
    }
}
