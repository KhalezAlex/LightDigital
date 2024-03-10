package org.klozevitz.lightdigital.services;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lightdigital.dao.serviceInterfaces.RoleService;
import org.klozevitz.lightdigital.dao.repositories.RoleRepository;
import org.klozevitz.lightdigital.model.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceServiceImplementation implements RoleService {
    private final RoleRepository repo;

    @Override
    public List<Role> all() {
        return repo.findAll();
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
