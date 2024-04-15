package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.Project;
import com.gestor.gestortareasbackend.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Operation(summary = "Obtener todos los proyectos")
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @Operation(summary = "Obtener un proyecto por su ID")
    @GetMapping("/{projectId}")
    public Project getProjectById(@Parameter(description = "ID del proyecto") @PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }

    @Operation(summary = "Crear un nuevo proyecto")
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @Operation(summary = "Actualizar un proyecto existente")
    @PutMapping("/{projectId}")
    public Project updateProject(@Parameter(description = "ID del proyecto") @PathVariable Long projectId,
                                 @RequestBody Project projectDetails) {
        return projectService.updateProject(projectId, projectDetails);
    }

    @Operation(summary = "Eliminar un proyecto")
    @DeleteMapping("/{projectId}")
    public void deleteProject(@Parameter(description = "ID del proyecto") @PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }
}
