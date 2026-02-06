package com.microservicios.usuarios.demo.infrastructure.in.rest.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}