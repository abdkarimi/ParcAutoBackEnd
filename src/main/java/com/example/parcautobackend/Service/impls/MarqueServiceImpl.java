package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Marque;
import com.example.parcautobackend.model.repositories.MarqueRepository;
import com.example.parcautobackend.Service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueServiceImpl implements MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    @Override
    public Marque saveMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    @Override
    public Optional<Marque> getMarqueById(Long id) {
        return marqueRepository.findById(id);
    }

    @Override
    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    @Override
    public Marque updateMarque(Long id, Marque marque) {
        if (marqueRepository.existsById(id)) {
            marque.setIdMarque(id);
            return marqueRepository.save(marque);
        }
        return null;
    }

    @Override
    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }
}
