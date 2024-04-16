package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.role.Role;
import com.gestor.gestortareasbackend.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByNameContainingIgnoreCase(String name);
}