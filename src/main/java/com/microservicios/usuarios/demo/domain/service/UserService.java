package com.microservicios.usuarios.demo.domain.service;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.ports.in.UserUseCase;
import com.microservicios.usuarios.demo.domain.ports.out.RoleRepository;
import com.microservicios.usuarios.demo.domain.ports.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository; // ¡Nuevo! Necesario para buscar roles

    @Override
    public User registrarUsuario(User usuario) {

        if (userRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya existe en el sistema");
        }


        if (usuario.getRole() == null) {

            roleRepository.findByNombre("USER").ifPresent(usuario::setRole);
        }

        return userRepository.save(usuario);
    }


    public User login(String email, String password) {
        User usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuario;
    }

    @Override
    public Optional<User> obtenerUsuarioPorId(Long id) {
        return userRepository.findById(id);
    }
}