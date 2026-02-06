package com.microservicios.usuarios.demo.domain.model;
import lombok.*;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Roles {
    private Long id;
    private String nombre;
    private List<Permissions> permisos;
}