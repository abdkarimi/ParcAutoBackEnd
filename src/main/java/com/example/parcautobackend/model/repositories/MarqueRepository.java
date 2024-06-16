package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
}