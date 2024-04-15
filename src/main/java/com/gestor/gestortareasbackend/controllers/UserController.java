package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.User;
import com.gestor.gestortareasbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Listar todos los usuarios, solo accesible por administradores
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener un usuario por ID, accesible por el propio usuario o por un administrador
    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Crear un usuario, abierto para todos pero idealmente debería ser restringido
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Actualizar un usuario, solo accesible por el propio usuario o un administrador
    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == principal.id")
    public User updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    // Eliminar un usuario, solo accesible por administradores
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
