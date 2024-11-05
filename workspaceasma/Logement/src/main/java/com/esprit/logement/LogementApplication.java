package com.esprit.logement;

import com.esprit.logement.entity.Lodging;
import com.esprit.logement.repository.LodgingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class LogementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogementApplication.class, args);
    }

    @Autowired
    private LodgingRepository lodgingRepository;

    @Bean
    ApplicationRunner init() {
        return args -> {
            // Enregistrer quelques logements dans la base
            lodgingRepository.save(new Lodging("Hotel Marina", "Tunis", 120.0));
            lodgingRepository.save(new Lodging("Villa Sidi Bou Said", "Sidi Bou Said",  300.0));
            lodgingRepository.save(new Lodging("Auberge Montagne", "Ain Draham",  60.0));

            // Récupérer et afficher tous les logements
            lodgingRepository.findAll().forEach(System.out::println);
        };
    }
}
