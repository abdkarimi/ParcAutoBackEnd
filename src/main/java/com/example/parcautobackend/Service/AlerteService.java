package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Alerte;
import java.util.List;
import java.util.Optional;

public interface AlerteService {
    Alerte saveAlerte(Alerte alerte);
    Optional<Alerte> getAlerteById(Long id);
    List<Alerte> getAllAlertes();
    Alerte updateAlerte(Long id, Alerte alerte);
    void deleteAlerte(Long id);
}
