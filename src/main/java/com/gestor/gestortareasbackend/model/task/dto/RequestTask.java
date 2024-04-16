package com.gestor.gestortareasbackend.model.task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestTask {
    @NotBlank(message = "El nombre de la tarea no puede estar vacío")
    private String name; // El nombre de la tarea

    private Set<Long> tagIds; // Conjunto de IDs de etiquetas para asociar a la tarea
}
