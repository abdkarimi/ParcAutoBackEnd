package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.TypeVehicule;
import java.util.List;
import java.util.Optional;

public interface TypeVehiculeService {
    TypeVehicule saveTypeVehicule(TypeVehicule typeVehicule);
    Optional<TypeVehicule> getTypeVehiculeById(Long id);
    List<TypeVehicule> getAllTypeVehicules();
    TypeVehicule updateTypeVehicule(Long id, TypeVehicule typeVehicule);
    void deleteTypeVehicule(Long id);
}
