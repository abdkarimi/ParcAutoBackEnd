package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Vehicule;
import java.util.List;
import java.util.Optional;

public interface VehiculeService {
    Vehicule saveVehicule(Vehicule vehicule);
    Optional<Vehicule> getVehiculeById(Long id);
    List<Vehicule> getAllVehicules();
    Vehicule updateVehicule(Long id, Vehicule vehicule);
    void deleteVehicule(Long id);
}
