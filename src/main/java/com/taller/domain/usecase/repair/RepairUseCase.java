package com.taller.domain.usecase.repair;

import com.taller.domain.model.repair.Repair;
import com.taller.domain.model.repair.gateway.RepairGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RepairUseCase {

    private final RepairGateway repairGateway;

    public Mono<Repair> addRepair(Repair repair){
        return repairGateway.addRepair(repair);
    }

    public Flux<Repair> findRepairEmployee(String employeeId){
        return repairGateway.findRepairEmployee(employeeId);
    }
}
