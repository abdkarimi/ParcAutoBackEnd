package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.TypeCarburant;
import java.util.List;
import java.util.Optional;

public interface TypeCarburantService {
    TypeCarburant saveTypeCarburant(TypeCarburant typeCarburant);
    Optional<TypeCarburant> getTypeCarburantById(Long id);
    List<TypeCarburant> getAllTypeCarburants();
    TypeCarburant updateTypeCarburant(Long id, TypeCarburant typeCarburant);
    void deleteTypeCarburant(Long id);
}
