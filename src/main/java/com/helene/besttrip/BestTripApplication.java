package com.helene.besttrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableDiscoveryClient
@EnableEurekaServer

@SpringBootApplication
public class BestTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestTripApplication.class, args);
    }

}
