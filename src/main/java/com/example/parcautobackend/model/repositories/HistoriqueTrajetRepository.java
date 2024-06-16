package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.HistoriqueTrajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueTrajetRepository extends JpaRepository<HistoriqueTrajet, Long> {
}