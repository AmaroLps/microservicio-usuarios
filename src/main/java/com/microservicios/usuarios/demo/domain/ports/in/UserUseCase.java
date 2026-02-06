package com.microservicios.usuarios.demo.domain.ports.in;

import com.microservicios.usuarios.demo.domain.model.User;
import java.util.Optional;

public interface UserUseCase {
    User registrarUsuario(User usuario);
    Optional<User> obtenerUsuarioPorId(Long id);
}