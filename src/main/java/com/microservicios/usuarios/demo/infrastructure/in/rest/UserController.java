package com.microservicios.usuarios.demo.infrastructure.in.rest;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.service.UserService;
import com.microservicios.usuarios.demo.infrastructure.in.rest.dto.UserRequest;
import com.microservicios.usuarios.demo.infrastructure.in.rest.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // api registrar un nuevo usuario
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

    // api obtener usuario por su aidi id xd
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> obtenerPorId(@PathVariable Long id) {
        return userService.obtenerUsuarioPorId(id)
                .map(user -> ResponseEntity.ok(mapearResponse(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    // api obtener solo el Rol de un usuario específico
    @GetMapping("/{id}/rol")
    public ResponseEntity<Roles> obtenerRolDelUsuario(@PathVariable Long id) {
        return userService.obtenerUsuarioPorId(id)
                .map(user -> ResponseEntity.ok(user.getRole()))
                .orElse(ResponseEntity.notFound().build());
    }

    // aqui mis kings colocare un metodo auxiliar para no repetir codigo
    // Esto evita repetir la construcción del builder en cada metodo
    private UserResponse mapearResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}