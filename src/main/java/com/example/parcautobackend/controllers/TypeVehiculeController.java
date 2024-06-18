package com.example.parcautobackend.controllers;

import com.example.parcautobackend.model.entities.TypeVehicule;
import com.example.parcautobackend.Service.TypeVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AULSH/typevehicules")
public class TypeVehiculeController {

    @Autowired
    private TypeVehiculeService typeVehiculeService;

    @PostMapping
    public ResponseEntity<TypeVehicule> createTypeVehicule(@RequestBody TypeVehicule typeVehicule) {
        TypeVehicule savedTypeVehicule = typeVehiculeService.saveTypeVehicule(typeVehicule);
        return ResponseEntity.ok(savedTypeVehicule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeVehicule> getTypeVehiculeById(@PathVariable Long id) {
        Optional<TypeVehicule> typeVehicule = typeVehiculeService.getTypeVehiculeById(id);
        return typeVehicule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TypeVehicule>> getAllTypeVehicules() {
        List<TypeVehicule> typeVehicules = typeVehiculeService.getAllTypeVehicules();
        return ResponseEntity.ok(typeVehicules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeVehicule> updateTypeVehicule(@PathVariable Long id, @RequestBody TypeVehicule typeVehicule) {
        TypeVehicule updatedTypeVehicule = typeVehiculeService.updateTypeVehicule(id, typeVehicule);
        return updatedTypeVehicule != null ? ResponseEntity.ok(updatedTypeVehicule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeVehicule(@PathVariable Long id) {
        typeVehiculeService.deleteTypeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
