package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Destination;
import com.example.parcautobackend.model.repositories.DestinationRepository;
import com.example.parcautobackend.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination updateDestination(Long id, Destination destination) {
        if (destinationRepository.existsById(id)) {
            destination.setIdDestination(id);
            return destinationRepository.save(destination);
        }
        return null;
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
