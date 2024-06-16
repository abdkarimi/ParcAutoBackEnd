package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Accident;
import com.example.parcautobackend.model.repositories.AccidentRepository;
import com.example.parcautobackend.Service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentServiceImpl implements AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    @Override
    public Accident saveAccident(Accident accident) {
        return accidentRepository.save(accident);
    }

    @Override
    public Optional<Accident> getAccidentById(Long id) {
        return accidentRepository.findById(id);
    }

    @Override
    public List<Accident> getAllAccidents() {
        return accidentRepository.findAll();
    }

    @Override
    public Accident updateAccident(Long id, Accident accident) {
        if (accidentRepository.existsById(id)) {
            accident.setIdAccident(id);
            return accidentRepository.save(accident);
        }
        return null;
    }

    @Override
    public void deleteAccident(Long id) {
        accidentRepository.deleteById(id);
    }
}
