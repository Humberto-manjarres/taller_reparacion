package com.taller.infraestructure.entry_points.reactive_web.employee;

import com.taller.domain.usecase.employee.EmployeeUseCase;
import com.taller.infraestructure.entry_points.reactive_web.employee.dto.EmployeeDTO;
import com.taller.infraestructure.entry_points.reactive_web.employee.transformers.EmployeeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**esta clase sera el controlador */

@Component
@RequiredArgsConstructor
public class EmployeeHandler {

    private final EmployeeUseCase employeeUseCase;

    private final EmployeeTransformer transformer;

    public Mono<ServerResponse> addEmployee(ServerRequest serverRequest){
        return serverRequest.bodyToMono(EmployeeDTO.class)
                .map(transformer::toEntity)
                .flatMap(employeeUseCase::addEmployee)
                .flatMap(savedEmployee -> ServerResponse.ok().bodyValue(savedEmployee));
    }

    public Mono<ServerResponse> updateEmployee(ServerRequest serverRequest){
        return Mono.empty();
    }

    public Mono<ServerResponse> findEmployee(ServerRequest serverRequest){
        String employeeId = serverRequest.pathVariable("employeeId");
        return employeeUseCase.findByDamageId(employeeId)
                .flatMap(findE -> ServerResponse.ok().bodyValue(findE));
    }

}
