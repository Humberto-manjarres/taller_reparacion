package com.taller.domain.model.repair.gateway;

import com.taller.domain.model.repair.Repair;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepairGateway {
    Mono<Repair> addRepair(Repair repair);
    Flux<Repair> findRepairEmployee(String emplopyeeId);
}
