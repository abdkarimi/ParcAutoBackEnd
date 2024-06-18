package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Alerte;
import com.example.parcautobackend.Service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/alertes")
public class AlerteController {

    @Autowired
    private AlerteService alerteService;

    @PostMapping
    public ResponseEntity<Alerte> createAlerte(@RequestBody Alerte alerte) {
        Alerte savedAlerte = alerteService.saveAlerte(alerte);
        return ResponseEntity.ok(savedAlerte);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerteById(@PathVariable Long id) {
        Optional<Alerte> alerte = alerteService.getAlerteById(id);
        return alerte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Alerte>> getAllAlertes() {
        List<Alerte> alertes = alerteService.getAllAlertes();
        return ResponseEntity.ok(alertes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerte> updateAlerte(@PathVariable Long id, @RequestBody Alerte alerte) {
        Alerte updatedAlerte = alerteService.updateAlerte(id, alerte);
        return updatedAlerte != null ? ResponseEntity.ok(updatedAlerte) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerte(@PathVariable Long id) {
        alerteService.deleteAlerte(id);
        return ResponseEntity.noContent().build();
    }
}
