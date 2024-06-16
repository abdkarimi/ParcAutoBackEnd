package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Garage;
import java.util.List;
import java.util.Optional;

public interface GarageService {
    Garage saveGarage(Garage garage);
    Optional<Garage> getGarageById(Long id);
    List<Garage> getAllGarages();
    Garage updateGarage(Long id, Garage garage);
    void deleteGarage(Long id);
}
