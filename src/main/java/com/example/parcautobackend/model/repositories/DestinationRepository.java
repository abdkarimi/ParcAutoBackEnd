package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}