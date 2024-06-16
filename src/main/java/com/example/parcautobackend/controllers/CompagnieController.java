package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.Compagnie;
import com.example.parcautobackend.Service.CompagnieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/compagnies")
public class CompagnieController {

    @Autowired
    private CompagnieService compagnieService;

    @PostMapping
    public ResponseEntity<Compagnie> createCompagnie(@RequestBody Compagnie compagnie) {
        Compagnie savedCompagnie = compagnieService.saveCompagnie(compagnie);
        return ResponseEntity.ok(savedCompagnie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compagnie> getCompagnieById(@PathVariable Long id) {
        Optional<Compagnie> compagnie = compagnieService.getCompagnieById(id);
        return compagnie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Compagnie>> getAllCompagnies() {
        List<Compagnie> compagnies = compagnieService.getAllCompagnies();
        return ResponseEntity.ok(compagnies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compagnie> updateCompagnie(@PathVariable Long id, @RequestBody Compagnie compagnie) {
        Compagnie updatedCompagnie = compagnieService.updateCompagnie(id, compagnie);
        return updatedCompagnie != null ? ResponseEntity.ok(updatedCompagnie) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompagnie(@PathVariable Long id) {
        compagnieService.deleteCompagnie(id);
        return ResponseEntity.noContent().build();
    }
}
