package org.klozevitz.lightdigital.services;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lightdigital.dao.serviceInterfaces.UserService;
import org.klozevitz.lightdigital.dao.repositories.UserRepository;
import org.klozevitz.lightdigital.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository repo;

    @Override
    public List<User> all() {
        return repo.findAll();
    }

    @Override
    public User findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        if (repo.findByUsername(user.getUsername()) != null) {
            return null;
        }
        return repo.save(user);
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
