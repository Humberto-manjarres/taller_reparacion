package com.taller.infraestructure.driven_adapters.dynamodb.repair;


import com.taller.domain.model.repair.Repair;
import com.taller.domain.model.repair.gateway.RepairGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RepairAdapter implements RepairGateway {

    private final RepairRepository repository;

    @Override
    public Mono<Repair> addRepair(Repair repair) {

        RepairItem repairItem = new RepairItem();
        repairItem.setPk("DAMAGE#" + repair.getDamageId());
        repairItem.setSk("REPAIRED_BY#EMPLOYEE#" + repair.getEmployeeId());
        repairItem.setEntityType("Repair");
        repairItem.setEmployeeId(repair.getEmployeeId());
        repairItem.setRepairDate(repair.getRepairDate());

        return repository.save(repairItem).thenReturn(repair);
    }

    @Override
    public Flux<Repair> findRepairEmployee(String employeeId) {
        return repository.findRepairEmployee(employeeId)
                .map(item -> {
                    Repair repair = new Repair();
                    repair.setDamageId(item.getPk().replace("DAMAGE#", ""));
                    repair.setEmployeeId(item.getEmployeeId());
                    repair.setRepairDate(item.getRepairDate());
                    return repair;
                });
    }
}
