package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.TypeCarburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCarburantRepository extends JpaRepository<TypeCarburant, Long> {
}