package com.microservicios.usuarios.demo.infrastructure.in.rest.dto;
import lombok.Data;
import java.util.List;

@Data
public class RoleRequest {
    private String nombre;
    private List<String> permisos; // Recibe strings simples ["/home", "/admin"]
}