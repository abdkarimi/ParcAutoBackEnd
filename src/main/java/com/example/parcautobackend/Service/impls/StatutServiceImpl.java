package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Statut;
import com.example.parcautobackend.model.repositories.StatutRepository;
import com.example.parcautobackend.Service.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatutServiceImpl implements StatutService {

    @Autowired
    private StatutRepository statutRepository;

    @Override
    public Statut saveStatut(Statut statut) {
        return statutRepository.save(statut);
    }

    @Override
    public Optional<Statut> getStatutById(Long id) {
        return statutRepository.findById(id);
    }

    @Override
    public List<Statut> getAllStatuts() {
        return statutRepository.findAll();
    }

    @Override
    public Statut updateStatut(Long id, Statut statut) {
        if (statutRepository.existsById(id)) {
            statut.setIdStatut(id);
            return statutRepository.save(statut);
        }
        return null;
    }

    @Override
    public void deleteStatut(Long id) {
        statutRepository.deleteById(id);
    }
}
