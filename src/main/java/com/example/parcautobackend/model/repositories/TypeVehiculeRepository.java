package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.TypeVehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Long> {
}