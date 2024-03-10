package org.klozevitz.lightdigital.services;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lightdigital.dao.serviceInterfaces.ClaimService;
import org.klozevitz.lightdigital.dao.repositories.ClaimRepository;
import org.klozevitz.lightdigital.model.entities.Claim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimServiceServiceImplementation implements ClaimService {
    private final ClaimRepository repo;

    @Override
    public List<Claim> all() {
        return repo.findAll();
    }

    @Override
    public Claim findById(int id) {
        return null;
    }

    @Override
    public Claim save(Claim claim) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
