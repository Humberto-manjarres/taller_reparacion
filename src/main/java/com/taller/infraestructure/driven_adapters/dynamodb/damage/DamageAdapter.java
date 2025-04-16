package com.taller.infraestructure.driven_adapters.dynamodb.damage;


import com.taller.domain.model.damage.Damage;
import com.taller.domain.model.damage.gateway.DamageGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItem;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DamageAdapter implements DamageGateway {

    private final RepairServiceItemRepository repository;

    @Override
    public Mono<Damage> addDamage(Damage damage) {

        DamageItem damageItem = DamageItem.builder()
                .pk("DAMAGE#" + damage.getId())
                .sk("INFO")
                .entityType("Damage")
                .description(damage.getDescription())
                .build();

        return repository.save(damageItem).thenReturn(damage);
    }

    @Override
    public Flux<RepairServiceItem> findByDamageId(String dagameId) {
        return repository.findByDamageId(dagameId);
    }
}
