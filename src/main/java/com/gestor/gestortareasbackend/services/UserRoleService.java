package com.gestor.gestortareasbackend.services;

import com.gestor.gestortareasbackend.model.Role;
import com.gestor.gestortareasbackend.model.User;
import com.gestor.gestortareasbackend.repository.RoleRepository;
import com.gestor.gestortareasbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void cambiarRolDeUsuario(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        user.setRole(role);
        userRepository.save(user);
    }
}