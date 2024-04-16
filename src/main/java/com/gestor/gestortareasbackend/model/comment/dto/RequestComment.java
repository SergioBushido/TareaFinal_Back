package com.gestor.gestortareasbackend.model.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestComment {
    @NotBlank(message = "El contenido del comentario no puede estar vacío")
    private String content; // El contenido del comentario

    @NonNull
    private Long userId; // ID del usuario que hace el comentario

    @NonNull
    private Long taskId; // ID de la tarea a la que se asocia el comentario
}
