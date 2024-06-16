package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Marque;
import com.example.parcautobackend.Service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/marques")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @PostMapping
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque) {
        Marque savedMarque = marqueService.saveMarque(marque);
        return ResponseEntity.ok(savedMarque);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Long id) {
        Optional<Marque> marque = marqueService.getMarqueById(id);
        return marque.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Marque>> getAllMarques() {
        List<Marque> marques = marqueService.getAllMarques();
        return ResponseEntity.ok(marques);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable Long id, @RequestBody Marque marque) {
        Marque updatedMarque = marqueService.updateMarque(id, marque);
        return updatedMarque != null ? ResponseEntity.ok(updatedMarque) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
        return ResponseEntity.noContent().build();
    }
}
