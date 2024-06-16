package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}