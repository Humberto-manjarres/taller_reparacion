package com.taller.infraestructure.entry_points.reactive_web.repair;


import com.taller.infraestructure.entry_points.reactive_web.routes.RepairRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RepairRouter {

    @Bean
    public RouterFunction<ServerResponse> routeRepair(RepairHandler handler){
        return route(POST(RepairRoutes.BASE + RepairRoutes.ASSIGN)
                .and(accept(MediaType.APPLICATION_JSON)), handler::addRepair);
    }
}
