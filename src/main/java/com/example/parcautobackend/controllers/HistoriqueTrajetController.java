package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.HistoriqueTrajet;
import com.example.parcautobackend.Service.HistoriqueTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/historiquetrajets")
public class HistoriqueTrajetController {

    @Autowired
    private HistoriqueTrajetService historiqueTrajetService;

    @PostMapping
    public ResponseEntity<HistoriqueTrajet> createHistoriqueTrajet(@RequestBody HistoriqueTrajet historiqueTrajet) {
        HistoriqueTrajet savedHistoriqueTrajet = historiqueTrajetService.saveHistoriqueTrajet(historiqueTrajet);
        return ResponseEntity.ok(savedHistoriqueTrajet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueTrajet> getHistoriqueTrajetById(@PathVariable Long id) {
        Optional<HistoriqueTrajet> historiqueTrajet = historiqueTrajetService.getHistoriqueTrajetById(id);
        return historiqueTrajet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HistoriqueTrajet>> getAllHistoriqueTrajets() {
        List<HistoriqueTrajet> historiqueTrajets = historiqueTrajetService.getAllHistoriqueTrajets();
        return ResponseEntity.ok(historiqueTrajets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueTrajet> updateHistoriqueTrajet(@PathVariable Long id, @RequestBody HistoriqueTrajet historiqueTrajet) {
        HistoriqueTrajet updatedHistoriqueTrajet = historiqueTrajetService.updateHistoriqueTrajet(id, historiqueTrajet);
        return updatedHistoriqueTrajet != null ? ResponseEntity.ok(updatedHistoriqueTrajet) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoriqueTrajet(@PathVariable Long id) {
        historiqueTrajetService.deleteHistoriqueTrajet(id);
        return ResponseEntity.noContent().build();
    }
}
