package com.example.parcautobackend.Service;

import com.example.parcautobackend.model.entities.HistoriqueTrajet;
import java.util.List;
import java.util.Optional;

public interface HistoriqueTrajetService {
    HistoriqueTrajet saveHistoriqueTrajet(HistoriqueTrajet historiqueTrajet);
    Optional<HistoriqueTrajet> getHistoriqueTrajetById(Long id);
    List<HistoriqueTrajet> getAllHistoriqueTrajets();
    HistoriqueTrajet updateHistoriqueTrajet(Long id, HistoriqueTrajet historiqueTrajet);
    void deleteHistoriqueTrajet(Long id);
}
