package com.microservicios.usuarios.demo.infrastructure.out.persistence.entity.mock;

import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.ports.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserRepositoryAdapter implements UserRepository {
    private final List<User> db = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public User save(User user) {
        if (user.getId() == null) user.setId(idGenerator.getAndIncrement());
        db.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return db.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return db.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }
}