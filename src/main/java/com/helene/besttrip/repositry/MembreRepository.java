package com.helene.besttrip.repositry;

import com.helene.besttrip.entities.MembreGroupe;
import com.helene.besttrip.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Key;
import java.util.List;
public interface MembreRepository extends JpaRepository<MembreGroupe,Long> {
    List<MembreGroupe> findByGroupeId(Long groupeId);
    List<MembreGroupe> findByRole(Role role);

}
