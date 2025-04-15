package com.taller.infraestructure.entry_points.reactive_web.damage;

import com.taller.domain.usecase.damage.DamageUseCase;
import com.taller.infraestructure.entry_points.reactive_web.damage.dto.DamageDTO;
import com.taller.infraestructure.entry_points.reactive_web.damage.transformers.DamageTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class DamageHandler {

    private final DamageUseCase damageUseCase;

    private final DamageTransformer transformer;

    public Mono<ServerResponse> addDamage(ServerRequest serverRequest){
        return serverRequest.bodyToMono(DamageDTO.class)
                .map(transformer::toEntity)
                .flatMap(damageUseCase::addDamage)
                .flatMap(savedEmployee -> ServerResponse.ok().bodyValue(savedEmployee));
    }

    public Mono<ServerResponse> findByDagame(ServerRequest serverRequest){
        String damageId = serverRequest.pathVariable("damageId");
        return damageUseCase.findByDamageId(damageId)
                .collectList()
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

}
