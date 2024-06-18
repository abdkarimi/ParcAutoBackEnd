package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.Concessionnaire;
import java.util.List;
import java.util.Optional;

public interface ConcessionnaireService {
    Concessionnaire saveConcessionnaire(Concessionnaire concessionnaire);
    Optional<Concessionnaire> getConcessionnaireById(Long id);
    List<Concessionnaire> getAllConcessionnaires();
    Concessionnaire updateConcessionnaire(Long id, Concessionnaire concessionnaire);
    void deleteConcessionnaire(Long id);
}
