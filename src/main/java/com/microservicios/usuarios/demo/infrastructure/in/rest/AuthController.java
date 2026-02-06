package com.microservicios.usuarios.demo.infrastructure.in.rest;

import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.service.UserService;
import com.microservicios.usuarios.demo.infrastructure.in.rest.dto.LoginRequest;
import com.microservicios.usuarios.demo.infrastructure.in.rest.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    // api login
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        User user = userService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(UserResponse.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .role(user.getRole())
                .build());
    }
}