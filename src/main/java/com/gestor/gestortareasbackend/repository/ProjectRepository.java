package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}