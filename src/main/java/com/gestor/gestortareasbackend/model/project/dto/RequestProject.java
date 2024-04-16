package com.gestor.gestortareasbackend.model.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestProject {
    @NotBlank(message = "El nombre del proyecto no puede estar vacío")
    private String name; // El nombre del proyecto

    private Set<Long> taskIds; // Conjunto de IDs de tareas para asociar al proyecto
    private Set<Long> memberIds; // Conjunto de IDs de usuarios para asociar como miembros del proyecto
}
