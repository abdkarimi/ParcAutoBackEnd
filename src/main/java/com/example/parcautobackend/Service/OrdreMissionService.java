package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.OrdreMission;
import java.util.List;
import java.util.Optional;

public interface OrdreMissionService {
    OrdreMission saveOrdreMission(OrdreMission ordreMission);
    Optional<OrdreMission> getOrdreMissionById(Long id);
    List<OrdreMission> getAllOrdreMissions();
    OrdreMission updateOrdreMission(Long id, OrdreMission ordreMission);
    void deleteOrdreMission(Long id);
}
