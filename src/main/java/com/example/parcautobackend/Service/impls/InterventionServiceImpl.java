package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Intervention;
import com.example.parcautobackend.model.repositories.InterventionRepository;
import com.example.parcautobackend.Service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterventionServiceImpl implements InterventionService {

    @Autowired
    private InterventionRepository interventionRepository;

    @Override
    public Intervention saveIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @Override
    public Optional<Intervention> getInterventionById(Long id) {
        return interventionRepository.findById(id);
    }

    @Override
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    @Override
    public Intervention updateIntervention(Long id, Intervention intervention) {
        if (interventionRepository.existsById(id)) {
            intervention.setIdIntervention(id);
            return interventionRepository.save(intervention);
        }
        return null;
    }

    @Override
    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }
}
