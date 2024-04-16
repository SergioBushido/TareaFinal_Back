package com.gestor.gestortareasbackend.services;


import com.gestor.gestortareasbackend.model.comment.Comment;
import com.gestor.gestortareasbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment commentDetails) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            // Actualizar los detalles del comentario
            // commentDetails.setId(commentId); // Si se desea mantener el mismo ID
            return commentRepository.save(commentDetails);
        }
        return null;
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}