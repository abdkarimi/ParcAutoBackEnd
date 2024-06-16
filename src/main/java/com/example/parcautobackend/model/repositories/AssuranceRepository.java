package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
}