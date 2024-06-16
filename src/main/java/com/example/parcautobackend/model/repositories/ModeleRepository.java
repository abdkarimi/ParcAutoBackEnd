package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeleRepository extends JpaRepository<Modele, Long> {
}