package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Assurance;
import java.util.List;
import java.util.Optional;

public interface AssuranceService {
    Assurance saveAssurance(Assurance assurance);
    Optional<Assurance> getAssuranceById(Long id);
    List<Assurance> getAllAssurances();
    Assurance updateAssurance(Long id, Assurance assurance);
    void deleteAssurance(Long id);
}
