package com.microservicios.usuarios.demo.infrastructure.out.persistence.entity.mock;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.ports.out.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRoleRepositoryAdapter implements RoleRepository {
    private final List<Roles> db = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Roles save(Roles role) {
        if (role.getId() == null) role.setId(idGenerator.getAndIncrement());
        db.add(role);
        return role;
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return db.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Roles> findByNombre(String nombre) {
        return db.stream().filter(r -> r.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}