package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.Task;
import com.gestor.gestortareasbackend.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Obtener todas las tareas")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(summary = "Obtener una tarea por su ID")
    @GetMapping("/{taskId}")
    public Task getTaskById(@Parameter(description = "ID de la tarea") @PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @Operation(summary = "Crear una nueva tarea")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @Operation(summary = "Actualizar una tarea existente")
    @PutMapping("/{taskId}")
    public Task updateTask(@Parameter(description = "ID de la tarea") @PathVariable Long taskId,
                           @RequestBody Task taskDetails) {
        return taskService.updateTask(taskId, taskDetails);
    }

    @Operation(summary = "Eliminar una tarea")
    @DeleteMapping("/{taskId}")
    public void deleteTask(@Parameter(description = "ID de la tarea") @PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
