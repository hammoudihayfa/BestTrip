package tn.esprit.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatwayRutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("bookingRoute", r -> r.path("/bookings/**").uri("http://localhost:8086"))
				.route("flightRoute", r -> r.path("/flights/**").uri("http://localhost:8086"))
				.route("passengerRoute", r -> r.path("/passengers/**").uri("http://localhost:8086"))
				.route("tripRoute", r -> r.path("/trips/**").uri("http://localhost:8086"))
				.route("seatRoute", r -> r.path("/seats/**").uri("http://localhost:8086"))
				.route("routeRoute", r -> r.path("/routes/**").uri("http://localhost:8086"))
				.route("userManagementRoute", r -> r.path("/api/**").uri("http://localhost:4000"))
				.build();

	}


}