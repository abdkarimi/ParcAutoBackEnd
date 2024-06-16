package com.example.parcautobackend.model.repositories;

import com.example.parcautobackend.model.entities.OrdreMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdreMissionRepository extends JpaRepository<OrdreMission, Long> {
}