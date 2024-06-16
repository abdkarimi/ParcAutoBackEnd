package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Vehicule;
import com.example.parcautobackend.model.repositories.VehiculeRepository;
import com.example.parcautobackend.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Optional<Vehicule> getVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        if (vehiculeRepository.existsById(id)) {
            vehicule.setIdVehicule(id);
            return vehiculeRepository.save(vehicule);
        }
        return null;
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}
