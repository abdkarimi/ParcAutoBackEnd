package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.HistoriqueTrajet;
import com.example.parcautobackend.model.repositories.HistoriqueTrajetRepository;
import com.example.parcautobackend.Service.HistoriqueTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueTrajetServiceImpl implements HistoriqueTrajetService {

    @Autowired
    private HistoriqueTrajetRepository historiqueTrajetRepository;

    @Override
    public HistoriqueTrajet saveHistoriqueTrajet(HistoriqueTrajet historiqueTrajet) {
        return historiqueTrajetRepository.save(historiqueTrajet);
    }

    @Override
    public Optional<HistoriqueTrajet> getHistoriqueTrajetById(Long id) {
        return historiqueTrajetRepository.findById(id);
    }

    @Override
    public List<HistoriqueTrajet> getAllHistoriqueTrajets() {
        return historiqueTrajetRepository.findAll();
    }

    @Override
    public HistoriqueTrajet updateHistoriqueTrajet(Long id, HistoriqueTrajet historiqueTrajet) {
        if (historiqueTrajetRepository.existsById(id)) {
            historiqueTrajet.setIdTrajet(id);
            return historiqueTrajetRepository.save(historiqueTrajet);
        }
        return null;
    }

    @Override
    public void deleteHistoriqueTrajet(Long id) {
        historiqueTrajetRepository.deleteById(id);
    }
}
