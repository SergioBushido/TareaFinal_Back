package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}