package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}