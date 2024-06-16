package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}