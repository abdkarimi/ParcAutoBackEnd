package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Enumeration;
import com.example.parcautobackend.model.repositories.EnumerationRepository;
import com.example.parcautobackend.Service.EnumerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnumerationServiceImpl implements EnumerationService {

    @Autowired
    private EnumerationRepository enumerationRepository;

    @Override
    public Enumeration saveEnumeration(Enumeration enumeration) {
        return enumerationRepository.save(enumeration);
    }

    @Override
    public Optional<Enumeration> getEnumerationById(Long id) {
        return enumerationRepository.findById(id);
    }

    @Override
    public List<Enumeration> getAllEnumerations() {
        return enumerationRepository.findAll();
    }

    @Override
    public Enumeration updateEnumeration(Long id, Enumeration enumeration) {
        if (enumerationRepository.existsById(id)) {
            enumeration.setIdEnumeration(id);
            return enumerationRepository.save(enumeration);
        }
        return null;
    }

    @Override
    public void deleteEnumeration(Long id) {
        enumerationRepository.deleteById(id);
    }
}
