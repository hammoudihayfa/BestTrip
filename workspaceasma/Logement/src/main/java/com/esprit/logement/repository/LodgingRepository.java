package com.esprit.logement.repository;

import com.esprit.logement.entity.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Integer> {

}
