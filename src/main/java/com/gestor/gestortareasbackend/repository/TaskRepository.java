package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}