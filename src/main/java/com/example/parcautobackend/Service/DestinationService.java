package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Destination;
import java.util.List;
import java.util.Optional;

public interface DestinationService {
    Destination saveDestination(Destination destination);
    Optional<Destination> getDestinationById(Long id);
    List<Destination> getAllDestinations();
    Destination updateDestination(Long id, Destination destination);
    void deleteDestination(Long id);
}
