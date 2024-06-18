package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepository extends JpaRepository<Garage, Long> {
}