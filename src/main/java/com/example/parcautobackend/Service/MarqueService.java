package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Marque;
import java.util.List;
import java.util.Optional;

public interface MarqueService {
    Marque saveMarque(Marque marque);
    Optional<Marque> getMarqueById(Long id);
    List<Marque> getAllMarques();
    Marque updateMarque(Long id, Marque marque);
    void deleteMarque(Long id);
}
