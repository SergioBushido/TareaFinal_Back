package com.gestor.gestortareasbackend.services;


import com.gestor.gestortareasbackend.model.Project;
import com.gestor.gestortareasbackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long projectId, Project projectDetails) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project != null) {
            // Actualizar los detalles del proyecto
            // projectDetails.setId(projectId); // Si se desea mantener el mismo ID
            return projectRepository.save(projectDetails);
        }
        return null;
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}