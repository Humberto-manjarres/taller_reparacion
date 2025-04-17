package com.taller.domain.model.damage.gateway;

import com.taller.domain.model.damage.Damage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DamageGateway {
    Mono<Damage> addDamage(Damage damage);
    Flux<Damage> findByDamageId(String dagameId);
}
