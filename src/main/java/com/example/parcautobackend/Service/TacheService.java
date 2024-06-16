package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Tache;
import java.util.List;
import java.util.Optional;

public interface TacheService {
    Tache saveTache(Tache tache);
    Optional<Tache> getTacheById(Long id);
    List<Tache> getAllTaches();
    Tache updateTache(Long id, Tache tache);
    void deleteTache(Long id);
}
