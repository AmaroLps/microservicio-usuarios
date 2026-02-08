package com.microservicios.usuarios.demo.domain.ports.out;

import com.microservicios.usuarios.demo.domain.model.Roles;
import java.util.Optional;

public interface RoleRepository {
    Roles save(Roles role);
    Optional<Roles> findById(Long id);
    Optional<Roles> findByNombre(String nombre);
}