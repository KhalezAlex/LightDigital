package org.klozevitz.lightdigital.dao.repositories;

import org.klozevitz.lightdigital.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
