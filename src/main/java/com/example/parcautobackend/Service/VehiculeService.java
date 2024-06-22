package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Vehicule;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface VehiculeService {
    Vehicule saveVehicule(MultipartFile file, Vehicule vehicule) throws IOException;
    Optional<Vehicule> getVehiculeById(Long id);
    List<Vehicule> getAllVehicules();
    Vehicule updateVehicule(Long id, MultipartFile file, Vehicule vehicule) throws IOException;
    Vehicule updateVehiculeWithoutImage(Vehicule vehicule);
    void deleteVehicule(Long id);
}
