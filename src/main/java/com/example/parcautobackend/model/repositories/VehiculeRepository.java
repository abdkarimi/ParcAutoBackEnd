package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}