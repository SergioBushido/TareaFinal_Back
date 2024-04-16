package com.gestor.gestortareasbackend.model.task.dto;

import com.gestor.gestortareasbackend.model.tag.dto.ResponseTag;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseTask {
    private Long id;
    private String name;
    private Set<ResponseTag> tags; // Set de tags asociados a la tarea
}
