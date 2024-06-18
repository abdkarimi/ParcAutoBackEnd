package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.TypeIntervention;
import com.example.parcautobackend.model.repositories.TypeInterventionRepository;
import com.example.parcautobackend.Service.TypeInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeInterventionServiceImpl implements TypeInterventionService {

    @Autowired
    private TypeInterventionRepository typeInterventionRepository;

    @Override
    public TypeIntervention saveTypeIntervention(TypeIntervention typeIntervention) {
        return typeInterventionRepository.save(typeIntervention);
    }

    @Override
    public Optional<TypeIntervention> getTypeInterventionById(Long id) {
        return typeInterventionRepository.findById(id);
    }

    @Override
    public List<TypeIntervention> getAllTypeInterventions() {
        return typeInterventionRepository.findAll();
    }

    @Override
    public TypeIntervention updateTypeIntervention(Long id, TypeIntervention typeIntervention) {
        if (typeInterventionRepository.existsById(id)) {
            typeIntervention.setIdTypeIntervention(id);
            return typeInterventionRepository.save(typeIntervention);
        }
        return null;
    }

    @Override
    public void deleteTypeIntervention(Long id) {
        typeInterventionRepository.deleteById(id);
    }
}
