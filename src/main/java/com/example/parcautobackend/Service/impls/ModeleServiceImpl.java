package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Modele;
import com.example.parcautobackend.model.repositories.ModeleRepository;
import com.example.parcautobackend.Service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeleServiceImpl implements ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    @Override
    public Modele saveModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    @Override
    public Optional<Modele> getModeleById(Long id) {
        return modeleRepository.findById(id);
    }

    @Override
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    @Override
    public Modele updateModele(Long id, Modele modele) {
        if (modeleRepository.existsById(id)) {
            modele.setIdModele(id);
            return modeleRepository.save(modele);
        }
        return null;
    }

    @Override
    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }
}
