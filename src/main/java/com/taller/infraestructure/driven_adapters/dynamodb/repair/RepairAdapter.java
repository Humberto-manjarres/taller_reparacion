package com.taller.infraestructure.driven_adapters.dynamodb.repair;


import com.taller.domain.model.repair.Repair;
import com.taller.domain.model.repair.gateway.RepairGateway;
import com.taller.infraestructure.driven_adapters.dynamodb.common.RepairServiceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RepairAdapter implements RepairGateway {

    private final RepairServiceItemRepository repository;

    @Override
    public Mono<Repair> addRepair(Repair repair) {

        RepairItem repairItem = RepairItem.builder()
                .pk("DAMAGE#" + repair.getDamageId())
                .sk("REPAIRED_BY#EMPLOYEE#" + repair.getEmployeeId())
                .entityType("Repair")
                .employeeId(repair.getEmployeeId())
                .repairDate(repair.getRepairDate())
                .build();

        return repository.save(repairItem).thenReturn(repair);
    }
}
