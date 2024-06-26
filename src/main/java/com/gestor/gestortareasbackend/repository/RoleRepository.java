package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   List<Role> findByNameContainingIgnoreCase(String name);
   Optional<Role> findByNameIgnoreCase(String name);

}