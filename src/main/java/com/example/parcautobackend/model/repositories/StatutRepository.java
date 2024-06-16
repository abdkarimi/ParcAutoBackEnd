package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutRepository extends JpaRepository<Statut, Long> {
}