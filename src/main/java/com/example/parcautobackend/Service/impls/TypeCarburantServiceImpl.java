package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.TypeCarburant;
import com.example.parcautobackend.model.repositories.TypeCarburantRepository;
import com.example.parcautobackend.Service.TypeCarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeCarburantServiceImpl implements TypeCarburantService {

    @Autowired
    private TypeCarburantRepository typeCarburantRepository;

    @Override
    public TypeCarburant saveTypeCarburant(TypeCarburant typeCarburant) {
        return typeCarburantRepository.save(typeCarburant);
    }

    @Override
    public Optional<TypeCarburant> getTypeCarburantById(Long id) {
        return typeCarburantRepository.findById(id);
    }

    @Override
    public List<TypeCarburant> getAllTypeCarburants() {
        return typeCarburantRepository.findAll();
    }

    @Override
    public TypeCarburant updateTypeCarburant(Long id, TypeCarburant typeCarburant) {
        if (typeCarburantRepository.existsById(id)) {
            typeCarburant.setIdTypeCarburant(id);
            return typeCarburantRepository.save(typeCarburant);
        }
        return null;
    }

    @Override
    public void deleteTypeCarburant(Long id) {
        typeCarburantRepository.deleteById(id);
    }
}
