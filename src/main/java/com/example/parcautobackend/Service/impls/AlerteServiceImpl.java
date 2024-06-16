package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Alerte;
import com.example.parcautobackend.model.repositories.AlerteRepository;
import com.example.parcautobackend.Service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlerteServiceImpl implements AlerteService {

    @Autowired
    private AlerteRepository alerteRepository;

    @Override
    public Alerte saveAlerte(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    @Override
    public Optional<Alerte> getAlerteById(Long id) {
        return alerteRepository.findById(id);
    }

    @Override
    public List<Alerte> getAllAlertes() {
        return alerteRepository.findAll();
    }

    @Override
    public Alerte updateAlerte(Long id, Alerte alerte) {
        if (alerteRepository.existsById(id)) {
            alerte.setIdAlerte(id);
            return alerteRepository.save(alerte);
        }
        return null;
    }

    @Override
    public void deleteAlerte(Long id) {
        alerteRepository.deleteById(id);
    }
}
