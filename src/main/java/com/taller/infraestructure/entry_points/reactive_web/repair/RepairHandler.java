package com.taller.infraestructure.entry_points.reactive_web.repair;

import com.taller.domain.model.repair.Repair;
import com.taller.domain.usecase.repair.RepairUseCase;
import com.taller.infraestructure.entry_points.reactive_web.repair.dto.RepairDTO;
import com.taller.infraestructure.entry_points.reactive_web.repair.transformers.RepairTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class RepairHandler {

    private final RepairUseCase repairUseCase;

    private final RepairTransformer transformer;

    public Mono<ServerResponse> addRepair(ServerRequest serverRequest){
        return serverRequest.bodyToMono(RepairDTO.class)
                .map(transformer::toEntity)
                .flatMap(repairUseCase::addRepair)
                .flatMap(savedRepair -> ServerResponse.ok().bodyValue(savedRepair));
    }

    public Mono<ServerResponse> findRepairEmployee(ServerRequest serverRequest){
        String employeeId = serverRequest.pathVariable("employeeId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(repairUseCase.findRepairEmployee(employeeId), Repair.class);
    }

    public Mono<ServerResponse> updateRepair(ServerRequest serverRequest){
        return Mono.empty();
    }

    public Mono<ServerResponse> findRepair(ServerRequest serverRequest){
        return Mono.empty();
    }

}
