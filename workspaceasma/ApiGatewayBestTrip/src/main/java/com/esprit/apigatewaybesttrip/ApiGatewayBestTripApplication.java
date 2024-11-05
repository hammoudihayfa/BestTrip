package com.esprit.apigatewaybesttrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayBestTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayBestTripApplication.class, args); }
        @Bean
                public RouteLocator gattewayRoutes(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route("Logement", r -> r.path("/lodgings/**")
                            .uri("http://localhost:8081"))
                    .build();


        }}




