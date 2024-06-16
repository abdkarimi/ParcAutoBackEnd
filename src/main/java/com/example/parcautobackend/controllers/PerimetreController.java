package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Perimetre;
import com.example.parcautobackend.Service.PerimetreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/perimetres")
public class PerimetreController {

    @Autowired
    private PerimetreService perimetreService;

    @PostMapping
    public ResponseEntity<Perimetre> createPerimetre(@RequestBody Perimetre perimetre) {
        Perimetre savedPerimetre = perimetreService.savePerimetre(perimetre);
        return ResponseEntity.ok(savedPerimetre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perimetre> getPerimetreById(@PathVariable Long id) {
        Optional<Perimetre> perimetre = perimetreService.getPerimetreById(id);
        return perimetre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Perimetre>> getAllPerimetres() {
        List<Perimetre> perimetres = perimetreService.getAllPerimetres();
        return ResponseEntity.ok(perimetres);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perimetre> updatePerimetre(@PathVariable Long id, @RequestBody Perimetre perimetre) {
        Perimetre updatedPerimetre = perimetreService.updatePerimetre(id, perimetre);
        return updatedPerimetre != null ? ResponseEntity.ok(updatedPerimetre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerimetre(@PathVariable Long id) {
        perimetreService.deletePerimetre(id);
        return ResponseEntity.noContent().build();
    }
}
