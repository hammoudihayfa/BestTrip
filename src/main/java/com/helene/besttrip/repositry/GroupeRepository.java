package com.helene.besttrip.repositry;

import com.helene.besttrip.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

        List<Groupe> findByDestination(String destination);


}
