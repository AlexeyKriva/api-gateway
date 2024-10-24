package com.software.modsen.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("passengerService", p -> p.path("/api/passengers/**")
                        .uri("lb://passenger-microservice"))
                .route("driverService", d -> d.path("/api/drivers/**")
                        .uri("lb://driver-microservice"))
                .route("carService", d -> d.path("/api/cars/**")
                        .uri("lb://driver-microservice"))
                .route("ridesService", r -> r.path("/api/rides/**")
                        .uri("lb://rides-microservice"))
                .route("ratingService", r -> r.path("/api/ratings/**")
                        .uri("lb://rating-microservice"))
                .route("ratingSourceService", r -> r.path("/api/ratings/sources/**")
                        .uri("lb://rating-microservice"))
                .build();
    }
}
