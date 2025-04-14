package com.taller.infraestructure.entry_points.reactive_web.employee;


import com.taller.infraestructure.entry_points.reactive_web.routes.EmployeeRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import  static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
@RequiredArgsConstructor
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> routeEmployee(EmployeeHandler handler){
        return route(POST(EmployeeRoutes.BASE + EmployeeRoutes.ADD)
                    .and(accept(MediaType.APPLICATION_JSON)), handler::addEmployee)
                .andRoute(PUT(EmployeeRoutes.BASE + EmployeeRoutes.UPDATE)
                    .and(accept(MediaType.APPLICATION_JSON)), handler::updateEmployee)
                .andRoute(GET(EmployeeRoutes.BASE + EmployeeRoutes.FIND)
                        .and(accept(MediaType.APPLICATION_JSON)), handler::findEmployee);
    }
}
