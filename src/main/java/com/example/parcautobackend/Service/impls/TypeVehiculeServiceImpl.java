package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.TypeVehicule;
import com.example.parcautobackend.model.repositories.TypeVehiculeRepository;
import com.example.parcautobackend.Service.TypeVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeVehiculeServiceImpl implements TypeVehiculeService {

    @Autowired
    private TypeVehiculeRepository typeVehiculeRepository;

    @Override
    public TypeVehicule saveTypeVehicule(TypeVehicule typeVehicule) {
        return typeVehiculeRepository.save(typeVehicule);
    }

    @Override
    public Optional<TypeVehicule> getTypeVehiculeById(Long id) {
        return typeVehiculeRepository.findById(id);
    }

    @Override
    public List<TypeVehicule> getAllTypeVehicules() {
        return typeVehiculeRepository.findAll();
    }

    @Override
    public TypeVehicule updateTypeVehicule(Long id, TypeVehicule typeVehicule) {
        if (typeVehiculeRepository.existsById(id)) {
            typeVehicule.setIdTypeVehicule(id);
            return typeVehiculeRepository.save(typeVehicule);
        }
        return null;
    }

    @Override
    public void deleteTypeVehicule(Long id) {
        typeVehiculeRepository.deleteById(id);
    }
}
