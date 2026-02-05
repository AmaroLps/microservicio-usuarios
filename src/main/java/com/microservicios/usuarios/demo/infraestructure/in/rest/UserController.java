package com.microservicios.usuarios.demo.infraestructure.in.rest;
//
public class UserController {
//
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
