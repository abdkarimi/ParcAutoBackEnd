package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructureRepository extends JpaRepository<Structure, Long> {
}