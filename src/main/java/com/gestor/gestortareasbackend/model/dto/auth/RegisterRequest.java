package com.gestor.gestortareasbackend.model.dto.auth;

import com.gestor.gestortareasbackend.model.role.Role;
import com.gestor.gestortareasbackend.model.role.dto.RequestRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Long roleId;
}
