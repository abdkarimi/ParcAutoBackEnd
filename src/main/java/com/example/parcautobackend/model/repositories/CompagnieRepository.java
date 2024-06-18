package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompagnieRepository extends JpaRepository<Compagnie, Long> {
}