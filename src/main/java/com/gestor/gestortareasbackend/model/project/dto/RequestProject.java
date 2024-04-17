package com.gestor.gestortareasbackend.model.project.dto;

import com.gestor.gestortareasbackend.model.task.dto.ResponseTask;
import com.gestor.gestortareasbackend.model.user.dto.ResponseUser;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestProject {
    @NotBlank
    private String name;
    private ResponseUser member;
    private Set<ResponseTask> tasks;

}
