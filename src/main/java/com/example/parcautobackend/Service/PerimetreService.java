package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Perimetre;
import java.util.List;
import java.util.Optional;

public interface PerimetreService {
    Perimetre savePerimetre(Perimetre perimetre);
    Optional<Perimetre> getPerimetreById(Long id);
    List<Perimetre> getAllPerimetres();
    Perimetre updatePerimetre(Long id, Perimetre perimetre);
    void deletePerimetre(Long id);
}
