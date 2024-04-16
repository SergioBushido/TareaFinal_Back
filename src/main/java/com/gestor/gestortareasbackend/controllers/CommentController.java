package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.comment.Comment;
import com.gestor.gestortareasbackend.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "Obtener todos los comentarios")
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @Operation(summary = "Obtener un comentario por su ID")
    @GetMapping("/{commentId}")
    public Comment getCommentById(@Parameter(description = "ID del comentario") @PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @Operation(summary = "Crear un nuevo comentario")
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @Operation(summary = "Actualizar un comentario existente")
    @PutMapping("/{commentId}")
    public Comment updateComment(@Parameter(description = "ID del comentario") @PathVariable Long commentId,
                                 @RequestBody Comment commentDetails) {
        return commentService.updateComment(commentId, commentDetails);
    }

    @Operation(summary = "Eliminar un comentario")
    @DeleteMapping("/{commentId}")
    public void deleteComment(@Parameter(description = "ID del comentario") @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
