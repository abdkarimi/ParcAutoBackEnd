package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Tache;
import com.example.parcautobackend.model.repositories.TacheRepository;
import com.example.parcautobackend.Service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheServiceImpl implements TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public Tache saveTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Optional<Tache> getTacheById(Long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache updateTache(Long id, Tache tache) {
        if (tacheRepository.existsById(id)) {
            tache.setIdTache(id);
            return tacheRepository.save(tache);
        }
        return null;
    }

    @Override
    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }
}
