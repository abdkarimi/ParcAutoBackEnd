package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Modele;
import com.example.parcautobackend.Service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modeles")
public class ModeleController {

    @Autowired
    private ModeleService modeleService;

    @PostMapping
    public ResponseEntity<Modele> createModele(@RequestBody Modele modele) {
        Modele savedModele = modeleService.saveModele(modele);
        return ResponseEntity.ok(savedModele);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> getModeleById(@PathVariable Long id) {
        Optional<Modele> modele = modeleService.getModeleById(id);
        return modele.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Modele>> getAllModeles() {
        List<Modele> modeles = modeleService.getAllModeles();
        return ResponseEntity.ok(modeles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modele> updateModele(@PathVariable Long id, @RequestBody Modele modele) {
        Modele updatedModele = modeleService.updateModele(id, modele);
        return updatedModele != null ? ResponseEntity.ok(updatedModele) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModele(@PathVariable Long id) {
        modeleService.deleteModele(id);
        return ResponseEntity.noContent().build();
    }
}
