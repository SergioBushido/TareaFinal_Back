package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.User;
import com.gestor.gestortareasbackend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Listar todos los usuarios (solo para administradores)")
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Obtener un usuario por su ID (accesible por el propio usuario o por un administrador)")
    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id")
    public User getUserById(@Parameter(description = "ID del usuario") @PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Operation(summary = "Crear un usuario (solo para administradores)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Actualizar un usuario (accesible por el propio usuario o por un administrador)")
    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id")
    public User updateUser(@Parameter(description = "ID del usuario") @PathVariable Long userId,
                           @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @Operation(summary = "Eliminar un usuario (solo para administradores)")
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@Parameter(description = "ID del usuario") @PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
