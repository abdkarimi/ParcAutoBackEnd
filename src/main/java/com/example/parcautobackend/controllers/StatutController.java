package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Statut;
import com.example.parcautobackend.Service.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/statuts")
public class StatutController {

    @Autowired
    private StatutService statutService;

    @PostMapping
    public ResponseEntity<Statut> createStatut(@RequestBody Statut statut) {
        Statut savedStatut = statutService.saveStatut(statut);
        return ResponseEntity.ok(savedStatut);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statut> getStatutById(@PathVariable Long id) {
        Optional<Statut> statut = statutService.getStatutById(id);
        return statut.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Statut>> getAllStatuts() {
        List<Statut> statuts = statutService.getAllStatuts();
        return ResponseEntity.ok(statuts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statut> updateStatut(@PathVariable Long id, @RequestBody Statut statut) {
        Statut updatedStatut = statutService.updateStatut(id, statut);
        return updatedStatut != null ? ResponseEntity.ok(updatedStatut) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatut(@PathVariable Long id) {
        statutService.deleteStatut(id);
        return ResponseEntity.noContent().build();
    }
}
