package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Compagnie;
import com.example.parcautobackend.model.repositories.CompagnieRepository;
import com.example.parcautobackend.Service.CompagnieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompagnieServiceImpl implements CompagnieService {

    @Autowired
    private CompagnieRepository compagnieRepository;

    @Override
    public Compagnie saveCompagnie(Compagnie compagnie) {
        return compagnieRepository.save(compagnie);
    }

    @Override
    public Optional<Compagnie> getCompagnieById(Long id) {
        return compagnieRepository.findById(id);
    }

    @Override
    public List<Compagnie> getAllCompagnies() {
        return compagnieRepository.findAll();
    }

    @Override
    public Compagnie updateCompagnie(Long id, Compagnie compagnie) {
        if (compagnieRepository.existsById(id)) {
            compagnie.setIdCompagnie(id);
            return compagnieRepository.save(compagnie);
        }
        return null;
    }

    @Override
    public void deleteCompagnie(Long id) {
        compagnieRepository.deleteById(id);
    }
}
