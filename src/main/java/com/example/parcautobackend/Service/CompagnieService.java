package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Compagnie;
import java.util.List;
import java.util.Optional;

public interface CompagnieService {
    Compagnie saveCompagnie(Compagnie compagnie);
    Optional<Compagnie> getCompagnieById(Long id);
    List<Compagnie> getAllCompagnies();
    Compagnie updateCompagnie(Long id, Compagnie compagnie);
    void deleteCompagnie(Long id);
}