package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.TypeIntervention;
import com.example.parcautobackend.Service.TypeInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/typeinterventions")
public class TypeInterventionController {

    @Autowired
    private TypeInterventionService typeInterventionService;

    @PostMapping
    public ResponseEntity<TypeIntervention> createTypeIntervention(@RequestBody TypeIntervention typeIntervention) {
        TypeIntervention savedTypeIntervention = typeInterventionService.saveTypeIntervention(typeIntervention);
        return ResponseEntity.ok(savedTypeIntervention);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeIntervention> getTypeInterventionById(@PathVariable Long id) {
        Optional<TypeIntervention> typeIntervention = typeInterventionService.getTypeInterventionById(id);
        return typeIntervention.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TypeIntervention>> getAllTypeInterventions() {
        List<TypeIntervention> typeInterventions = typeInterventionService.getAllTypeInterventions();
        return ResponseEntity.ok(typeInterventions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeIntervention> updateTypeIntervention(@PathVariable Long id, @RequestBody TypeIntervention typeIntervention) {
        TypeIntervention updatedTypeIntervention = typeInterventionService.updateTypeIntervention(id, typeIntervention);
        return updatedTypeIntervention != null ? ResponseEntity.ok(updatedTypeIntervention) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeIntervention(@PathVariable Long id) {
        typeInterventionService.deleteTypeIntervention(id);
        return ResponseEntity.noContent().build();
    }
}
