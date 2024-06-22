package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Assurance;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AssuranceService {
    Assurance saveAssurance(MultipartFile file, Assurance assurance) throws IOException;
    Optional<Assurance> getAssuranceById(Long id);
    List<Assurance> getAllAssurances();
    Assurance updateAssurance(Long id, MultipartFile file, Assurance assurance) throws IOException;
    void deleteAssurance(Long id);
}
