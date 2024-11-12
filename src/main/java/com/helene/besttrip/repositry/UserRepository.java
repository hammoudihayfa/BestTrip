package com.helene.besttrip.repositry;

import com.helene.besttrip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
