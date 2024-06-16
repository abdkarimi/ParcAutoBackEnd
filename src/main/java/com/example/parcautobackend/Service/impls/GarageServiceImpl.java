package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Garage;
import com.example.parcautobackend.model.repositories.GarageRepository;
import com.example.parcautobackend.Service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    private GarageRepository garageRepository;

    @Override
    public Garage saveGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        if (garageRepository.existsById(id)) {
            garage.setIdGarage(id);
            return garageRepository.save(garage);
        }
        return null;
    }

    @Override
    public void deleteGarage(Long id) {
        garageRepository.deleteById(id);
    }
}
