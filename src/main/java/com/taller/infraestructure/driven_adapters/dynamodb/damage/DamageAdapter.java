package com.taller.infraestructure.driven_adapters.dynamodb.damage;


import com.taller.domain.model.damage.Damage;
import com.taller.domain.model.damage.gateway.DamageGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DamageAdapter implements DamageGateway {

    private final DamageRepository repository;

    @Override
    public Mono<Damage> addDamage(Damage damage) {

        DamageItem damageItem = new DamageItem();
        damageItem.setPk("DAMAGE#" + damage.getId());
        damageItem.setSk("INFO");
        damageItem.setEntityType("Damage");
        damageItem.setId(damage.getId());
        damageItem.setDescription(damage.getDescription());

        return repository.save(damageItem).thenReturn(damage);
    }

    @Override
    public Flux<Damage> findByDamageId(String dagameId) {
        return repository.findByDamageId(dagameId);
    }
}
