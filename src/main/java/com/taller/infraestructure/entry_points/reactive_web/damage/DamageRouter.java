package com.taller.infraestructure.entry_points.reactive_web.damage;

import com.taller.infraestructure.entry_points.reactive_web.routes.DamageRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class DamageRouter {

    @Bean
    public RouterFunction<ServerResponse> routeDamage(DamageHandler handler){
        return route(POST(DamageRoutes.BASE + DamageRoutes.REPORT)
                    .and(accept(MediaType.APPLICATION_JSON)), handler::addDamage)
                .andRoute(GET(DamageRoutes.BASE + DamageRoutes.FIND)
                    .and(accept(MediaType.APPLICATION_JSON)), handler::findByDagame);
    }
}
