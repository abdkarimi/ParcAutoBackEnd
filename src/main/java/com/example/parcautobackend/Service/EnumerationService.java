package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Enumeration;
import java.util.List;
import java.util.Optional;

public interface EnumerationService {
    Enumeration saveEnumeration(Enumeration enumeration);
    Optional<Enumeration> getEnumerationById(Long id);
    List<Enumeration> getAllEnumerations();
    Enumeration updateEnumeration(Long id, Enumeration enumeration);
    void deleteEnumeration(Long id);
}
