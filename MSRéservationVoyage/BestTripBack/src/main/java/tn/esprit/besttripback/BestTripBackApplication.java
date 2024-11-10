package tn.esprit.besttripback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.besttripback.Entity.Flight;
import tn.esprit.besttripback.Repository.FlightRepository;

import java.time.LocalDateTime;
@EnableDiscoveryClient
@SpringBootApplication
public class BestTripBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestTripBackApplication.class, args);
    }

    @Autowired
    private FlightRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            repository.save(new Flight(null, "New York", "Paris", LocalDateTime.parse("2024-10-01T10:00:00"), LocalDateTime.parse("2024-10-01T20:00:00"), null));
            repository.save(new Flight(null, "Berlin", "Londres", LocalDateTime.parse("2024-10-02T09:00:00"), LocalDateTime.parse("2024-10-02T19:00:00"), null));
            repository.save(new Flight(null, "Madrid", "Rome", LocalDateTime.parse("2024-10-03T08:00:00"), LocalDateTime.parse("2024-10-03T18:00:00"), null));
            repository.save(new Flight(null, "Tokyo", "Seoul", LocalDateTime.parse("2024-10-04T07:00:00"), LocalDateTime.parse("2024-10-04T17:00:00"), null));

            repository.findAll().forEach(System.out::println);
        };
    }
}
