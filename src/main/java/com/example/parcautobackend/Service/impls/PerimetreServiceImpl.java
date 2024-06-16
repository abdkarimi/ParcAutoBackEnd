package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Perimetre;
import com.example.parcautobackend.model.repositories.PerimetreRepository;
import com.example.parcautobackend.Service.PerimetreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerimetreServiceImpl implements PerimetreService {

    @Autowired
    private PerimetreRepository perimetreRepository;

    @Override
    public Perimetre savePerimetre(Perimetre perimetre) {
        return perimetreRepository.save(perimetre);
    }

    @Override
    public Optional<Perimetre> getPerimetreById(Long id) {
        return perimetreRepository.findById(id);
    }

    @Override
    public List<Perimetre> getAllPerimetres() {
        return perimetreRepository.findAll();
    }

    @Override
    public Perimetre updatePerimetre(Long id, Perimetre perimetre) {
        if (perimetreRepository.existsById(id)) {
            perimetre.setIdPerimetre(id);
            return perimetreRepository.save(perimetre);
        }
        return null;
    }

    @Override
    public void deletePerimetre(Long id) {
        perimetreRepository.deleteById(id);
    }
}
