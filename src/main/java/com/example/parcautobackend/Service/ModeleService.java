package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Modele;
import java.util.List;
import java.util.Optional;

public interface ModeleService {
    Modele saveModele(Modele modele);
    Optional<Modele> getModeleById(Long id);
    List<Modele> getAllModeles();
    Modele updateModele(Long id, Modele modele);
    void deleteModele(Long id);
}
