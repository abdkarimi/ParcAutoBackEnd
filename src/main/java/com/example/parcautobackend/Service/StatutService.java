package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Statut;
import java.util.List;
import java.util.Optional;

public interface StatutService {
    Statut saveStatut(Statut statut);
    Optional<Statut> getStatutById(Long id);
    List<Statut> getAllStatuts();
    Statut updateStatut(Long id, Statut statut);
    void deleteStatut(Long id);
}
