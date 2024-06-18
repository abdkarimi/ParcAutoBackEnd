package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}