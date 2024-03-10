package org.klozevitz.lightdigital.dao.repositories;

import org.klozevitz.lightdigital.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
