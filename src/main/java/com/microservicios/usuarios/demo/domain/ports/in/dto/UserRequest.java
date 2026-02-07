package com.microservicios.usuarios.demo.domain.ports.in.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String password;
}