package com.gestor.gestortareasbackend.controllers;

import com.gestor.gestortareasbackend.model.comment.Comment;
import com.gestor.gestortareasbackend.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "Obtener todos los comentarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentarios obtenidos exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comment.class)))
    })
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @Operation(summary = "Obtener un comentario por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentario obtenido exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comment.class))),
            @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    })
    @GetMapping("/{commentId}")
    public Comment getCommentById(@Parameter(description = "ID del comentario") @PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @Operation(summary = "Crear un nuevo comentario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comentario creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comment.class)))
    })
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @Operation(summary = "Actualizar un comentario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentario actualizado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comment.class))),
            @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    })
    @PutMapping("/{commentId}")
    public Comment updateComment(@Parameter(description = "ID del comentario") @PathVariable Long commentId,
                                 @RequestBody Comment commentDetails) {
        return commentService.updateComment(commentId, commentDetails);
    }

    @Operation(summary = "Eliminar un comentario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Comentario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Comentario no encontrado")
    })
    @DeleteMapping("/{commentId}")
    public void deleteComment(@Parameter(description = "ID del comentario") @PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
