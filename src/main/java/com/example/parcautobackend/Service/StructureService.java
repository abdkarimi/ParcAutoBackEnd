package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Structure;
import java.util.List;
import java.util.Optional;

public interface StructureService {
    Structure saveStructure(Structure structure);
    Optional<Structure> getStructureById(Long id);
    List<Structure> getAllStructures();
    Structure updateStructure(Long id, Structure structure);
    void deleteStructure(Long id);
}
