package com.gestor.gestortareasbackend.model.task.dto;

import com.gestor.gestortareasbackend.model.project.dto.ResponseProject;
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
    private ResponseProject project;
    private Set<ResponseTag> tags;
}
