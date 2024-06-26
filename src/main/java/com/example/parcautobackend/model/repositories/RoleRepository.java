package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}