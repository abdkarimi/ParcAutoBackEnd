package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.TypeIntervention;
import java.util.List;
import java.util.Optional;

public interface TypeInterventionService {
    TypeIntervention saveTypeIntervention(TypeIntervention typeIntervention);
    Optional<TypeIntervention> getTypeInterventionById(Long id);
    List<TypeIntervention> getAllTypeInterventions();
    TypeIntervention updateTypeIntervention(Long id, TypeIntervention typeIntervention);
    void deleteTypeIntervention(Long id);
}
