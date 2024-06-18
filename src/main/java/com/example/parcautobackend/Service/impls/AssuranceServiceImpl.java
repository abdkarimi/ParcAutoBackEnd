package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Assurance;
import com.example.parcautobackend.model.repositories.AssuranceRepository;
import com.example.parcautobackend.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    @Override
    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    public Optional<Assurance> getAssuranceById(Long id) {
        return assuranceRepository.findById(id);
    }

    @Override
    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance updateAssurance(Long id, Assurance assurance) {
        if (assuranceRepository.existsById(id)) {
            assurance.setIdAssurance(id);
            return assuranceRepository.save(assurance);
        }
        return null;
    }

    @Override
    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }
}
