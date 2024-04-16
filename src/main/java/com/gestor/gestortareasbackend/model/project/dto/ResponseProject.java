package com.gestor.gestortareasbackend.model.project.dto;

import com.gestor.gestortareasbackend.model.task.dto.ResponseTask;
import com.gestor.gestortareasbackend.model.user.dto.ResponseUser;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseProject {
    private Long id;
    private String name;

    // Conjunto de tareas asociadas al proyecto
    private Set<ResponseTask> tasks;

    // Conjunto de miembros del proyecto
    private Set<ResponseUser> members;
}
