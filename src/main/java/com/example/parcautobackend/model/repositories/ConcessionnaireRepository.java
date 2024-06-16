package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Concessionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionnaireRepository extends JpaRepository<Concessionnaire, Long> {
}