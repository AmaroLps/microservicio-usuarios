package com.microservicios.usuarios.demo.infraestructure.in.rest.dto;
//
import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.ports.service.UserService;
import com.microservicios.usuarios.demo.infraestructure.in.rest.dto.UserRequest;
import com.microservicios.usuarios.demo.infraestructure.in.rest.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservicios.usuarios.demo.domain.model.Roles;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Registrar usuario
    @PostMapping
    public ResponseEntity<UserResponse> registrar(@RequestBody UserRequest request) {
        User user = userService.registrarUsuario(
                User.builder()
                        .nombre(request.getNombre())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .build()
        );
        return ResponseEntity.ok(mapearResponse(user));
    }

    // Login usuario
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request) {
        User user = userService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(mapearResponse(user));
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> obtenerPorId(@PathVariable Long id) {
        return userService.obtenerUsuarioPorId(id)
                .map(user -> ResponseEntity.ok(mapearResponse(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener rol del usuario
    @GetMapping("/{id}/rol")
    public ResponseEntity<Roles> obtenerRolDelUsuario(@PathVariable Long id) {
        return userService.obtenerUsuarioPorId(id)
                .map(user -> ResponseEntity.ok(user.getRole()))
                .orElse(ResponseEntity.notFound().build());
    }

    // Método auxiliar para mapear User a UserResponse
    private UserResponse mapearResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}


