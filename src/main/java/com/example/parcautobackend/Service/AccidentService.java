package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Accident;
import java.util.List;
import java.util.Optional;

public interface AccidentService {
    Accident saveAccident(Accident accident);
    Optional<Accident> getAccidentById(Long id);
    List<Accident> getAllAccidents();
    Accident updateAccident(Long id, Accident accident);
    void deleteAccident(Long id);
}
