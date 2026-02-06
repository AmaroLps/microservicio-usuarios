package com.microservicios.usuarios.demo.infrastructure.in.rest;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.service.RoleService;
import com.microservicios.usuarios.demo.infrastructure.in.rest.dto.RoleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // api registro de rol
    @PostMapping
    public ResponseEntity<Roles> crearRol(@RequestBody RoleRequest request) {
        Roles rol = roleService.crearRol(request.getNombre(), request.getPermisos());
        return ResponseEntity.ok(rol);
    }

    // api para obtener las runas que tiene el rol
    //  mis kings aqui cuando  devuelve el objeto roles completo pues java como que serializa la lista de permisos automáticamente dentro pes
    @GetMapping("/{id}")
    public ResponseEntity<Roles> obtenerRolConPermisos(@PathVariable Long id) {
        return roleService.obtenerRolPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}