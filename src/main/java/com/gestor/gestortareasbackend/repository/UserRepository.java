package com.gestor.gestortareasbackend.repository;

import com.gestor.gestortareasbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}