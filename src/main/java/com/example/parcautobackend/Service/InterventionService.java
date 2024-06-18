package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Intervention;
import java.util.List;
import java.util.Optional;

public interface InterventionService {
    Intervention saveIntervention(Intervention intervention);
    Optional<Intervention> getInterventionById(Long id);
    List<Intervention> getAllInterventions();
    Intervention updateIntervention(Long id, Intervention intervention);
    void deleteIntervention(Long id);
}
