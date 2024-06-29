package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.OrdreMission;
import com.example.parcautobackend.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdreMissionRepository extends JpaRepository<OrdreMission, Long> {
    List<OrdreMission> findByAgent(Utilisateur agent);
}