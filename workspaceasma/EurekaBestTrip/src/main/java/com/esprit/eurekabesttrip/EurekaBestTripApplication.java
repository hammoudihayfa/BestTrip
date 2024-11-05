package com.esprit.eurekabesttrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaBestTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaBestTripApplication.class, args);
    }

}
