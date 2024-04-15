package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.Tag;
import com.gestor.gestortareasbackend.services.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @Operation(summary = "Obtener todas las etiquetas")
    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @Operation(summary = "Obtener una etiqueta por su ID")
    @GetMapping("/{tagId}")
    public Tag getTagById(@Parameter(description = "ID de la etiqueta") @PathVariable Long tagId) {
        return tagService.getTagById(tagId);
    }

    @Operation(summary = "Crear una nueva etiqueta")
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @Operation(summary = "Actualizar una etiqueta existente")
    @PutMapping("/{tagId}")
    public Tag updateTag(@Parameter(description = "ID de la etiqueta") @PathVariable Long tagId,
                         @RequestBody Tag tagDetails) {
        return tagService.updateTag(tagId, tagDetails);
    }

    @Operation(summary = "Eliminar una etiqueta")
    @DeleteMapping("/{tagId}")
    public void deleteTag(@Parameter(description = "ID de la etiqueta") @PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}
