package org.klozevitz.lightdigital.dao.repositories;

import org.klozevitz.lightdigital.model.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
