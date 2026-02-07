package com.microservicios.usuarios.demo.infraestructure.in.rest;
//
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
//    //api login
//
//    // api registro de usuario
//
//    //api get by id usuario
//
//    // api de registro de rol
//
//    //api get de rol del usuario
//
//    //api get de rutas que tiene el rol vienen los permisos por dentro
//
//    DECLARE
//    v_result JSON;
//    BEGIN
//    SELECT json_agg(
//            json_build_object(
//                    'route_id', r.route_id,
//            'route_code', r.route_code,
//            'route_path', r.route_path,
//            'route_name', r.route_name,
//            'route_icon', r.route_icon,
//            'route_order', r.route_order,
//            'parent_route_id', r.parent_route_id,
//            'is_menu_item', r.is_menu_item,
//            'permissions', (
//            SELECT array_agg(p.permission_code ORDER BY p.permission_code)
//    FROM "LPS_ERP_LATAM".role_route_permissions rrp
//    INNER JOIN "LPS_ERP_LATAM".permissions p ON rrp.permission_id = p.permission_id
//    WHERE rrp.role_id = p_role_id
//    AND rrp.route_id = r.route_id
//    AND p.permission_status = 'active'
//            )
//            )
//    ORDER BY r.route_order, r.route_name
//    ) INTO v_result
//    FROM "LPS_ERP_LATAM".role_routes rr
//    INNER JOIN "LPS_ERP_LATAM".routes r ON rr.route_id = r.route_id
//    WHERE rr.role_id = p_role_id
//    AND r.route_status = 'active';
//
//    RETURN COALESCE(v_result, '[]'::json);
////    END;

   // busque el role id qe va a venir como parametro y luego que apunte a la tabla r
//
//
//
}
